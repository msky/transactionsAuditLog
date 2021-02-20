package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.shared.EventBus
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED

class HardcodedDataFacadeSpec extends Specification {

    EventBus eventBus = Mock()
    FileLocationProvider accountTypesFileLocationProvider = Mock()
    HardcodedDataFacade facade

    def setup() {
        facade = new HardcodedDataFacadeConfiguration()
                .hardcodedDataFacade(eventBus, accountTypesFileLocationProvider)
    }

    def "produce new account types definitions according to the content of csv file"() {
        given: "there is a csv file with a row containing account type 'saving account'"
            accountTypesFileLocationProvider.getResourcePath() >> "/hardcodeddata/account_types_with_saving_account.csv"

        and: "we expect new account type to be defined"
            def definedAccountType

        when: "processing of the account types has been triggered"
            facade.publishAccountTypesDefinition()

        then: "account type has been converted to new account type definition and published"
            eventBus.publish(_ as NewAccountTypeDefined) >> { NewAccountTypeDefined publishedEvent -> definedAccountType = publishedEvent }
            definedAccountType == SAVING_ACCOUNT_TYPE_DEFINED
    }
}
