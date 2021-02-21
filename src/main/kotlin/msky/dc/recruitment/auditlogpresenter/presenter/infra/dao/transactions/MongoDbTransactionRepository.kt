package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbTransactionRepository : MongoRepository<Transaction, String> {
    fun save(transaction: Transaction)

    fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>,
                                                                           customersIds: List<String>): List<Transaction>

    fun findAllByOrderByTransactionAmountAsc(): List<Transaction>

    fun findAllByCustomerIdInOrderByTransactionAmountAsc(requestedCustomersIds: List<String>): List<Transaction>

    fun findAllByAccountTypeIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>): List<Transaction>
}