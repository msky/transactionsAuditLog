package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class NewCustomerRegisteredPublisher(private val eventBus: EventBus,
                                     private val customersFileLocationProvider: FileLocationProvider) {

    fun publishNewCustomersRegisteredEvents() {
        this::class.java.getResourceAsStream(customersFileLocationProvider.getResourcePath())
                .bufferedReader()
                .forEachLine { convertToEventAndPublish(it) }
    }

    private fun convertToEventAndPublish(csvLine: String) {
        val newCustomerRegistered = convertToNewCustomerRegistered(csvLine)
        eventBus.publish(newCustomerRegistered)
    }

    private fun convertToNewCustomerRegistered(csvLine: String): NewCustomerRegistered {
        val newCustomerRegisteredFields = csvLine.split(",") // TODO extract and replace with library

        val id = newCustomerRegisteredFields[0]
        val firstName = newCustomerRegisteredFields[1]
        val lastName = newCustomerRegisteredFields[2]

        return NewCustomerRegistered(id, firstName, lastName)
    }

}
