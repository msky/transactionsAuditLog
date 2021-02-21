package msky.dc.recruitment.auditlogpresenter.presenter.domain

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AuditLogPresenterFacadeConfiguration {

    @Bean
    fun auditLogPresenterFacade(transactionRepository: TransactionRepository,
                                customerRepository: CustomerRepository,
                                accountTypeRepository: AccountTypeRepository): AuditLogPresenterFacade {
        return AuditLogPresenterFacadeImpl(customerRepository, accountTypeRepository,
                TransactionProjectionBuilder(customerRepository, accountTypeRepository, transactionRepository),
                transactionRepository)
    }
}