package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import java.util.Collections.synchronizedList

class InMemoryTransactionRepository(private val transactions: MutableList<Transaction> = synchronizedList(ArrayList()))
    : TransactionRepository {

    override fun findTransactionsByQueryOrderByAmountAsc(query: ShowTransactionsQuery): List<Transaction> {
        return transactions
                .filter {
                    query.showAllAccounts() || query.containsAccountId(it.accountTypeId())
                }.filter {
                    query.showAllCustomers() || query.containsCustomerId(it.customerId())
                }.sortedBy { it.transactionAmount }
    }

    override fun save(transaction: Transaction) {
        transactions.add(transaction)
    }
}