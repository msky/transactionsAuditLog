package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.acountTypes.InMemoryAccountTypeRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.customers.InMemoryCustomerRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions.InMemoryTransactionRepository
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.ANDRZEJ_KOWALSKI_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.JAN_NOWAK_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_ALL_JAN_NOWAK_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_ALL_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_VIEW

class QueryByCustomerIdSpec extends Specification {

    AuditLogPresenterFacade facade

    def setup() {
        facade = new AuditLogPresenterFacadeConfiguration().auditLogPresenterFacade(
                new InMemoryTransactionRepository(),
                new InMemoryCustomerRepository(),
                new InMemoryAccountTypeRepository()
        )
    }

    def "query by customer id shows only transactions performed by given customer"() {
        given: "saving account type has been created"
            facade.handle(SAVING_ACCOUNT_TYPE_DEFINED)

        and: "andrzej kowalski and jan nowak have registered"
            facade.handle(ANDRZEJ_KOWALSKI_REGISTERED)
            facade.handle(JAN_NOWAK_REGISTERED)

        and: "both the customers has made some transactions"
            facade.handle(ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED)
            facade.handle(JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED)

        when: "we ask for transactions performed by Jan Nowak"
            def transactionLog = facade.showTransactions(SHOW_ALL_JAN_NOWAK_TRANSACTIONS)

        then: "we see only transaction performed by Jan Nowak"
            transactionLog.transactions == [JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_VIEW]
    }

    def "query without specified customerId shows transactions performed by all customers"() {
        given: "saving account type has been created"
            facade.handle(SAVING_ACCOUNT_TYPE_DEFINED)

        and: "andrzej kowalski and jan nowak have registered"
            facade.handle(ANDRZEJ_KOWALSKI_REGISTERED)
            facade.handle(JAN_NOWAK_REGISTERED)

        and: "both the customers has made some transactions"
            facade.handle(ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED)
            facade.handle(JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED)

        when: "we ask for transactions without specifying customer"
            def transactionLog = facade.showTransactions(SHOW_ALL_TRANSACTIONS)

        then: "we see all transactions"
            transactionLog.transactions == [ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW, JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_VIEW]
    }

}
