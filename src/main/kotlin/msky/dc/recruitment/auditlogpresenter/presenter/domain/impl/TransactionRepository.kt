package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

interface TransactionRepository {
    fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>,
                                                                           customersIds: List<String>): List<Transaction>

    fun save(transaction: Transaction)
}
