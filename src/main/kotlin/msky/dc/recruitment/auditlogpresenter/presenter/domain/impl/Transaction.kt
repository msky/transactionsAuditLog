package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionDto
import java.math.BigDecimal
import java.time.LocalDateTime

class Transaction(private val transactionId: String,
                  val transactionAmount: BigDecimal,
                  private val transactionDate: LocalDateTime,
                  private val accountType: AccountType,
                  private val customer: Customer) {

    fun toDto(): TransactionDto {
        return TransactionDto(transactionId, transactionAmount, transactionDate,
                accountType.name,
                customer.firstName, customer.lastName)
    }

    fun accountTypeId(): String {
        return accountType.id
    }

    class AccountType(val id: String, val name: String) {
    }

    class Customer(val firstName: String, val lastName: String) {
    }
}
