package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbTransactionRepository : MongoRepository<Transaction, String> {
    fun save(transaction: Transaction)

    fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(accountTypesIds: List<String>,
                                                                           customersIds: List<String>): List<Transaction>

    fun findAllByOrderByTransactionAmountAsc(): List<Transaction>

    fun findAllByCustomerIdInOrderByTransactionAmountAsc(customersIds: List<String>): List<Transaction>

    fun findAllByAccountTypeIdInOrderByTransactionAmountAsc(accountTypesIds: List<String>): List<Transaction>
}