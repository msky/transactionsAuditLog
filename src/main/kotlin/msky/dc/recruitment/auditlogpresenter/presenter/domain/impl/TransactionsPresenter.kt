package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery

class TransactionsPresenter(private val transactionRepository: TransactionRepository) {

    fun showTransactions(query: ShowTransactionsQuery): List<Transaction> {
        return transactionRepository.findAllByAccountTypeId(query.requestedAccountTypesIds)
    }

}
