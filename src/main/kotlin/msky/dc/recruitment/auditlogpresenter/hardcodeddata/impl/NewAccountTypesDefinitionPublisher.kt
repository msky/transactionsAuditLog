package msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined
import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class NewAccountTypesDefinitionPublisher(private val eventBus: EventBus,
                                         private val accountTypesFileLocationProvider: FileLocationProvider,
                                         private val csvContentReader: CsvContentReader) {

    fun publishNewAccountTypesDefinedEvents() {
        val resourcePath = accountTypesFileLocationProvider.getResourcePath()
        csvContentReader.getCsvHeaderlessContentLines(resourcePath)
                .forEach { convertToEventAndPublish(it) }
    }

    private fun convertToEventAndPublish(csvLineElements: Array<String>) {
        val newAccountTypeDefined = convertToNewAccountTypeDefined(csvLineElements)
        eventBus.publish(newAccountTypeDefined)
    }

    private fun convertToNewAccountTypeDefined(newAccountTypeDefinedFields: Array<String>): NewAccountTypeDefined {
        val id = newAccountTypeDefinedFields[0]
        val name = newAccountTypeDefinedFields[1]

        return NewAccountTypeDefined(id, name)
    }

}