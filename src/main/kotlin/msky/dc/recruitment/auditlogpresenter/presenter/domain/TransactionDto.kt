package msky.dc.recruitment.auditlogpresenter.presenter.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(val transactionId: String,
                          val transactionAmount: BigDecimal,
                          val transactionDate: LocalDateTime,
                          val accountTypeName: String,
                          val customerFirstName: String,
                          val customerLastName: String) {

}
