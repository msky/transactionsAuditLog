package msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered
import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class NewCustomerRegisteredPublisher(private val eventBus: EventBus,
                                     private val customersFileLocationProvider: FileLocationProvider,
                                     private val csvContentReader: CsvContentReader) {

    fun publishNewCustomersRegisteredEvents() {
        csvContentReader.getCsvHeaderlessContentLines(customersFileLocationProvider.getResourcePath())
                .forEach { convertToEventAndPublish(it) }
    }

    private fun convertToEventAndPublish(csvLineElements: Array<String>) {
        val newCustomerRegistered = convertToNewCustomerRegistered(csvLineElements)
        eventBus.publish(newCustomerRegistered)
    }

    private fun convertToNewCustomerRegistered(newCustomerRegisteredFields: Array<String>): NewCustomerRegistered {
        val id = newCustomerRegisteredFields[0]
        val firstName = newCustomerRegisteredFields[1]
        val lastName = newCustomerRegisteredFields[2]

        return NewCustomerRegistered(id, firstName, lastName)
    }

}
