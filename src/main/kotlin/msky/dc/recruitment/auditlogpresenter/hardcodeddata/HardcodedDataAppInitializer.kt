package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class HardcodedDataAppInitializer(@Autowired private val hardcodedDataFacade: HardcodedDataFacade) {

    @EventListener
    fun fillTheAppWithHardcodedData(applicationReadyEvent: ApplicationReadyEvent) {
        hardcodedDataFacade.publishAccountTypesDefinition()
        hardcodedDataFacade.publishCustomersRegistered()
        hardcodedDataFacade.publishTransactions()
    }
}