package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import java.util.Collections.synchronizedList

class InMemoryTransactionRepository(private val transactions: MutableList<Transaction> = synchronizedList(ArrayList()))
    : TransactionRepository {

    override fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>,
                                                                                    customersIds: List<String>): List<Transaction> {
        return transactions
                .filter {
                    requestedAccountTypesIds.isEmpty() || requestedAccountTypesIds.contains(it.accountTypeId())
                }.filter {
                    customersIds.isEmpty() || customersIds.contains(it.customerId())
                }
                .sortedBy { it.transactionAmount }
    }

    override fun save(transaction: Transaction) {
        transactions.add(transaction)
    }
}