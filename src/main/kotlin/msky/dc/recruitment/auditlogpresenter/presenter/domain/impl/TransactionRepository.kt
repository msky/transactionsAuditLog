package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

interface TransactionRepository { // TODO remember about sorting
    fun findAllByAccountTypeId(requestedAccountTypesIds: List<String>): List<Transaction>
    fun save(transaction: Transaction)
}
