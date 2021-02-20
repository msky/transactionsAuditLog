package msky.dc.recruitment.auditlogpresenter.hardcodeddata

class HardcodedDataFacade(private val newAccountTypesDefinedPublisher: NewAccountTypesDefinitionPublisher,
                          private val newCustomerRegisteredPublisher: NewCustomerRegisteredPublisher,
                          private val newTransactionCompletedPublisher: NewTransactionCompletedPublisher) {

    fun publishAccountTypesDefinition() {
        newAccountTypesDefinedPublisher.publishNewAccountTypesDefinedEvents()
    }

    fun publishCustomersRegistered() {
        newCustomerRegisteredPublisher.publishNewCustomersRegisteredEvents()
    }

    fun publishTransactions() {
        newTransactionCompletedPublisher.publishNewTransactionsCompletedEvents()
    }
}