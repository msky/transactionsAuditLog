package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class NewAccountTypesDefinitionPublisher(private val eventBus: EventBus,
                                         private val accountTypesFileLocationProvider: FileLocationProvider) {

    fun publishNewAccountTypesDefinedEvents() {
        this::class.java.getResourceAsStream(accountTypesFileLocationProvider.getResourcePath())
                .bufferedReader()
                .forEachLine { convertToEventAndPublish(it) }
    }

    private fun convertToEventAndPublish(csvLine: String) {
        val newAccountTypeDefined = convertToNewAccountTypeDefined(csvLine)
        eventBus.publish(newAccountTypeDefined)
    }

    private fun convertToNewAccountTypeDefined(csvLine: String): NewAccountTypeDefined {
        val newAccountTypeDefinedFields = csvLine.split(",")  // TODO extract and replace with library

        val id = newAccountTypeDefinedFields[0]
        val name = newAccountTypeDefinedFields[1]

        return NewAccountTypeDefined(id, name)
    }

}