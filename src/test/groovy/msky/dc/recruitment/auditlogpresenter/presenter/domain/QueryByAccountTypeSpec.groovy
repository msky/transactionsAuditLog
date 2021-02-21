package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.InMemoryAccountTypeRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.InMemoryCustomerRepository
import msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions.InMemoryTransactionRepository
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.CURRENCY_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.ANDRZEJ_KOWALSKI_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_ALL_TRANSACTIONS_ON_CURRENCY_ACCOUNTS_QUERY
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_ALL_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_VIEW
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW

class QueryByAccountTypeSpec extends Specification {

    AuditLogPresenterFacade facade

    def setup() {
        facade = new AuditLogPresenterFacadeConfiguration().auditLogPresenterFacade(
                new InMemoryTransactionRepository(),
                new InMemoryCustomerRepository(),
                new InMemoryAccountTypeRepository()
        )
    }

    def "query by account type shows only transactions made on accounts with given type"() {
        given: "two different account types has been defined - saving and currency"
            facade.handle(SAVING_ACCOUNT_TYPE_DEFINED)
            facade.handle(CURRENCY_ACCOUNT_TYPE_DEFINED)

        and: "andrzej kowalski has registered"
            facade.handle(ANDRZEJ_KOWALSKI_REGISTERED)

        and: "andrzej has made transactions on both account types"
            facade.handle(ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED)
            facade.handle(ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED)

        when: "we ask for transactions performed on currency account type"
            def transactionLog = facade.showTransactions(SHOW_ALL_TRANSACTIONS_ON_CURRENCY_ACCOUNTS_QUERY)

        then: "we see only transaction performed on currency account type"
            transactionLog.transactions == [ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_VIEW]
    }

    def "querying without specified account type shows transactions performed on any account type"() {
        given: "two different account types has been defined - saving and currency"
            facade.handle(SAVING_ACCOUNT_TYPE_DEFINED)
            facade.handle(CURRENCY_ACCOUNT_TYPE_DEFINED)

        and: "andrzej kowalski has registered"
            facade.handle(ANDRZEJ_KOWALSKI_REGISTERED)

        and: "andrzej has made transactions on both account types"
            facade.handle(ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED)
            facade.handle(ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED)

        when: "we ask for transactions without specifying account type"
            def transactionLog = facade.showTransactions(SHOW_ALL_TRANSACTIONS)

        then: "we see all transactions"
            transactionLog.transactions == [ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_VIEW,
                                            ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW]
    }
}
