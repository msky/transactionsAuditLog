package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted
import msky.dc.recruitment.auditlogpresenter.presenter.domain.AuditLogPresenterFacade
import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery
import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionsLogDto

class AuditLogPresenterFacadeImpl(private val customerRepository: CustomerRepository,
                                  private val accountTypeRepository: AccountTypeRepository,
                                  private val transactionProjectionBuilder: TransactionProjectionBuilder,
                                  private val transactionsPresenter: TransactionsPresenter)
    : AuditLogPresenterFacade {

    override fun showTransactions(query: ShowTransactionsQuery): TransactionsLogDto {
        return TransactionsLogDto(transactionsPresenter
                .showTransactions(query)
                .map { it.toDto() }
        )
    }

    override fun handle(newAccountTypeDefined: NewAccountTypeDefined) {
        accountTypeRepository.save(AccountType(newAccountTypeDefined.id,
                newAccountTypeDefined.name))
    }

    override fun handle(newCustomerRegistered: NewCustomerRegistered) {
        customerRepository.save(Customer(newCustomerRegistered.id,
                newCustomerRegistered.firstName, newCustomerRegistered.lastName))
    }

    override fun handle(newTransactionCompleted: NewTransactionCompleted) {
        transactionProjectionBuilder.buildTransactionProjection(newTransactionCompleted)
    }
}