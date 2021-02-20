package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.NewAccountTypesDefinitionPublisher
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.NewCustomerRegisteredPublisher
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.NewTransactionCompletedPublisher

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