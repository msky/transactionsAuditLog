package msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted
import msky.dc.recruitment.auditlogpresenter.shared.EventBus
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewTransactionCompletedPublisher(private val eventBus: EventBus,
                                       private val transactionsFileLocationProvider: FileLocationProvider,
                                       private val csvContentReader: CsvContentReader) {

    fun publishNewTransactionsCompletedEvents() {
        csvContentReader.getCsvHeaderlessContentLines(transactionsFileLocationProvider.getResourcePath())
                .forEach { convertToEventAndPublish(it) }
    }

    private fun convertToEventAndPublish(csvLineElements: Array<String>) {
        val newTransactionCompleted = convertToNewTransactionCompleted(csvLineElements)
        eventBus.publish(newTransactionCompleted)
    }

    private fun convertToNewTransactionCompleted(newTransactionCompletedFields: Array<String>): NewTransactionCompleted {
        val transactionId = newTransactionCompletedFields[0]
        val transactionAmount = convertTransactionAmount(newTransactionCompletedFields[1])
        val accountTypeId = newTransactionCompletedFields[2]
        val customerId = newTransactionCompletedFields[3]
        val transactionDate = convertTransactionDate(newTransactionCompletedFields[4])

        return NewTransactionCompleted(transactionId,
                transactionAmount,
                accountTypeId,
                customerId,
                transactionDate)
    }

    private fun convertTransactionDate(transactionDate: String) =
            LocalDateTime.parse(transactionDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    private fun convertTransactionAmount(transactionAmount: String): BigDecimal =
            BigDecimal(transactionAmount.replace(",", "."))

}
