package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.*

class AuditLogPresenterFacadeConfiguration {

    fun auditLogPresenterFacade(transactionRepository: TransactionRepository,
                                customerRepository: CustomerRepository,
                                accountTypeRepository: AccountTypeRepository): AuditLogPresenterFacade {
        return AuditLogPresenterFacade(customerRepository, accountTypeRepository,
                TransactionProjectionBuilder(customerRepository, accountTypeRepository, transactionRepository),
                TransactionsPresenter(transactionRepository))
    }
}