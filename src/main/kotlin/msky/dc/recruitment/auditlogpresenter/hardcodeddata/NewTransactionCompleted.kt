package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import java.math.BigDecimal
import java.time.LocalDateTime

data class NewTransactionCompleted(private val transactionId: String,
                                   private val transactionAmount: BigDecimal,
                                   private val accountTypeId: String,
                                   private val customerId: String,
                                   private val transactionDate: LocalDateTime) {
}
