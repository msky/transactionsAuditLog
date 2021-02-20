package msky.dc.recruitment.auditlogpresenter.hardcodeddata

class HardcodedDataFacade(private val newAccountTypesDefinedPublisher: NewAccountTypesDefinitionPublisher) {

    fun publishAccountTypesDefinition() {
        newAccountTypesDefinedPublisher.publishNewAccountTypesDefinedEvents()
    }
}