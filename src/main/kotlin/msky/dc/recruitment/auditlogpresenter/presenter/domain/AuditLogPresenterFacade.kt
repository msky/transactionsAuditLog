package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted

interface AuditLogPresenterFacade {
    fun showTransactions(query: ShowTransactionsQuery): TransactionsLogDto
    fun handle(newAccountTypeDefined: NewAccountTypeDefined)
    fun handle(newCustomerRegistered: NewCustomerRegistered)
    fun handle(newTransactionCompleted: NewTransactionCompleted)
}