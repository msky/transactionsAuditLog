package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery

interface TransactionRepository {
    fun findTransactionsByQueryOrderByAmountAsc(query: ShowTransactionsQuery): List<Transaction>

    fun save(transaction: Transaction)
}
