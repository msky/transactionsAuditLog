package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.math.BigDecimal
import java.time.LocalDateTime

class Transaction(@Id private val transactionId: String,
                  @Field(targetType = FieldType.DECIMAL128) val transactionAmount: BigDecimal,
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

    fun customerId(): String {
        return customer.id
    }

    class AccountType(val id: String, val name: String) {
    }

    class Customer(val id: String, val firstName: String, val lastName: String) {
    }
}
