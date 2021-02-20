package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.*
import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class HardcodedDataFacadeConfiguration {

    fun hardcodedDataFacade(eventBus: EventBus,
                            accountTypesFileLocationProvider: FileLocationProvider,
                            customersFileLocationProvider: FileLocationProvider,
                            transactionsFileLocationProvider: FileLocationProvider): HardcodedDataFacade {
        val csvContentReader = CsvContentReader()

        return HardcodedDataFacade(
                NewAccountTypesDefinitionPublisher(eventBus, accountTypesFileLocationProvider, csvContentReader),
                NewCustomerRegisteredPublisher(eventBus, customersFileLocationProvider, csvContentReader),
                NewTransactionCompletedPublisher(eventBus, transactionsFileLocationProvider, csvContentReader))
    }
}