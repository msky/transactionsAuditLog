package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.impl.*
import msky.dc.recruitment.auditlogpresenter.shared.EventBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HardcodedDataFacadeConfiguration {

    @Bean
    fun resourceBasedHardcodedDataFacade(eventBus: EventBus): HardcodedDataFacade {
        return hardcodedDataFacade(eventBus,
                object : FileLocationProvider {
                    override fun getResourcePath(): String {
                        return "/hardcodeddata/accounttypes.csv"
                    }
                },
                object : FileLocationProvider {
                    override fun getResourcePath(): String {
                        return "/hardcodeddata/customers.csv"
                    }
                },
                object : FileLocationProvider {
                    override fun getResourcePath(): String {
                        return "/hardcodeddata/transactions.csv"
                    }
                }
        )
    }

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