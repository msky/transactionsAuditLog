package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import java.util.Collections.synchronizedList

class InMemoryTransactionRepository(private val transactions: MutableList<Transaction> = synchronizedList(ArrayList())) : TransactionRepository {

    override fun findAllByAccountTypeId(requestedAccountTypesIds: List<String>): List<Transaction> {
        return transactions.filter {
            requestedAccountTypesIds.contains(it.accountTypeId())
        }
    }

    override fun save(transaction: Transaction) {
        transactions.add(transaction)
    }
}