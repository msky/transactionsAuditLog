package msky.dc.recruitment.auditlogpresenter.hardcodeddata

class HardcodedDataFacade(private val newAccountTypesDefinedPublisher: NewAccountTypesDefinitionPublisher,
                          private val newCustomerRegisteredPublisher: NewCustomerRegisteredPublisher) {

    fun publishAccountTypesDefinition() {
        newAccountTypesDefinedPublisher.publishNewAccountTypesDefinedEvents()
    }

    fun publishCustomersRegistered() {
        newCustomerRegisteredPublisher.publishNewCustomersRegisteredEvents()
    }
}