package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.shared.EventBus

class HardcodedDataFacadeConfiguration {

    fun hardcodedDataFacade(eventBus: EventBus,
                            accountTypesFileLocationProvider: FileLocationProvider): HardcodedDataFacade {
        return HardcodedDataFacade(
                NewAccountTypesDefinitionPublisher(eventBus, accountTypesFileLocationProvider))
    }
}