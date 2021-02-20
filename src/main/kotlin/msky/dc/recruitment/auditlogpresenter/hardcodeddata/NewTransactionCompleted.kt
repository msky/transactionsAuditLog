package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import java.math.BigDecimal
import java.time.LocalDateTime

data class NewTransactionCompleted(val transactionId: String,
                                   val transactionAmount: BigDecimal,
                                   val accountTypeId: String,
                                   val customerId: String,
                                   val transactionDate: LocalDateTime) {
}
