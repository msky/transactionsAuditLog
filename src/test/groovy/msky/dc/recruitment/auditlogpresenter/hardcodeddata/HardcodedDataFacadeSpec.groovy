package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.FileLocationProvider
import msky.dc.recruitment.auditlogpresenter.shared.EventBus
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.ANDRZEJ_KOWALSKI_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.NEW_TRANSACTION_COMPLETED

class HardcodedDataFacadeSpec extends Specification {

    EventBus eventBus = Mock()
    FileLocationProvider accountTypesFileLocationProvider = Mock()
    FileLocationProvider customersFileLocationProvider = Mock()
    FileLocationProvider transactionsFileLocationProvider = Mock()
    HardcodedDataFacade facade

    def setup() {
        facade = new HardcodedDataFacadeConfiguration()
                .hardcodedDataFacade(eventBus,
                        accountTypesFileLocationProvider,
                        customersFileLocationProvider,
                        transactionsFileLocationProvider)
    }

    def "produce new account types definitions according to the content of csv file"() {
        given: "there is a csv file with a row containing account type 'saving account'"
            accountTypesFileLocationProvider.getResourcePath() >> "/hardcodeddata/account_types_with_saving_account.csv"

        and: "we expect new account type to be defined"
            def definedAccountType

        when: "processing of the account types has been triggered"
            facade.publishAccountTypesDefinition()

        then: "account type has been converted to new account type definition and published"
            1 * eventBus.publish(_ as NewAccountTypeDefined) >> { NewAccountTypeDefined publishedEvent -> definedAccountType = publishedEvent }

        and: "all values were properly set as event payload"
            definedAccountType == SAVING_ACCOUNT_TYPE_DEFINED
    }

    def "produce new customer registered events based on the content of csv file"() {
        given: "there is a csv file with a row containing customer 'Andrzej Kowalski' "
            customersFileLocationProvider.getResourcePath() >> "/hardcodeddata/customer_andrzej_kowalski.csv"

        and: "we expect an event informing that new customer has registered"
            def newCustomerRegistered

        when: "processing of the customers has been triggered"
            facade.publishCustomersRegistered()

        then: "customer data has been converted to event and published"
            1 * eventBus.publish(_ as NewCustomerRegistered) >> { NewCustomerRegistered publishedEvent -> newCustomerRegistered = publishedEvent }

        and: "all values were properly set as event payload"
            newCustomerRegistered == ANDRZEJ_KOWALSKI_REGISTERED
    }

    def "produce new transaction completed based on the content of csv file"() {
        given: "there is a csv file with a row containing single transaction"
            transactionsFileLocationProvider.getResourcePath() >> "/hardcodeddata/sample_transaction.csv"

        and: "we expect an event informing that new transaction has been completed"
            def newTransactionCompleted

        when: "processing of the account types has been triggered"
            facade.publishTransactions()

        then: "customer data has been converted to event and published"
            1 * eventBus.publish(_ as NewTransactionCompleted) >> { NewTransactionCompleted publishedEvent -> newTransactionCompleted = publishedEvent }

        and: "all values were properly set as event payload"
            newTransactionCompleted == NEW_TRANSACTION_COMPLETED
    }

}
