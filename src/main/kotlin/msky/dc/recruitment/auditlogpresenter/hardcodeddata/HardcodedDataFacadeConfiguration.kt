package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class HardcodedDataFacadeConfiguration {

    fun hardcodedDataFacade(eventBus: EventBus,
                            accountTypesFileLocationProvider: FileLocationProvider,
                            customersFileLocationProvider: FileLocationProvider): HardcodedDataFacade {
        val csvContentReader = CsvContentReader()

        return HardcodedDataFacade(
                NewAccountTypesDefinitionPublisher(eventBus, accountTypesFileLocationProvider, csvContentReader),
                NewCustomerRegisteredPublisher(eventBus, customersFileLocationProvider, csvContentReader))
    }
}