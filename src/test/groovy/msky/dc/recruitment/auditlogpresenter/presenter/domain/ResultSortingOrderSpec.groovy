package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.InMemoryAccountTypeRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.InMemoryCustomerRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.InMemoryTransactionRepository
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.CURRENCY_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.ANDRZEJ_KOWALSKI_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_ALL_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_VIEW
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_VIEW

class ResultSortingOrderSpec extends Specification {
    AuditLogPresenterFacade facade

    def setup() {
        facade = new AuditLogPresenterFacadeConfiguration().auditLogPresenterFacade(
                new InMemoryTransactionRepository(),
                new InMemoryCustomerRepository(),
                new InMemoryAccountTypeRepository()
        )
    }

    def "transactions should be sorted ascending by transaction amount"() {
        given: "two different account types has been defined - saving and currency"
            facade.handle(SAVING_ACCOUNT_TYPE_DEFINED)
            facade.handle(CURRENCY_ACCOUNT_TYPE_DEFINED)

        and: "andrzej kowalski has registered"
            facade.handle(ANDRZEJ_KOWALSKI_REGISTERED)

        and: "andrzej has made one transactions with different amounts- one with 100 and later on one with 10"
            facade.handle(ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_COMPLETED)
            facade.handle(ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_COMPLETED)

        when: "we ask for transactions without specifying account type"
            def transactionLog = facade.showTransactions(SHOW_ALL_TRANSACTIONS)

        then: "transactions are sorted ascending by amount"
            transactionLog.transactions == [ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_VIEW,
                                            ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_VIEW]
    }

}
