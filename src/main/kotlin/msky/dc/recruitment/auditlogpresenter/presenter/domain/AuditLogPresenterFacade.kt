package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.*

class AuditLogPresenterFacade(private val customerRepository: CustomerRepository,
                              private val accountTypeRepository: AccountTypeRepository,
                              private val transactionProjectionBuilder: TransactionProjectionBuilder,
                              private val transactionsPresenter: TransactionsPresenter) {

    fun showTransactions(query: ShowTransactionsQuery): TransactionsLogDto {
        return TransactionsLogDto(transactionsPresenter
                .showTransactions(query)
                .map { it.toDto() }
        )
    }

    fun handle(newAccountTypeDefined: NewAccountTypeDefined) {
        accountTypeRepository.save(AccountType(newAccountTypeDefined.id,
                newAccountTypeDefined.name))
    }

    fun handle(newCustomerRegistered: NewCustomerRegistered) {
        customerRepository.save(Customer(newCustomerRegistered.id,
                newCustomerRegistered.firstName, newCustomerRegistered.lastName))
    }

    fun handle(newTransactionCompleted: NewTransactionCompleted) {
        transactionProjectionBuilder.buildTransactionProjection(newTransactionCompleted)
    }
}