package msky.dc.recruitment.auditlogpresenter.presenter.infra.listener

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered
import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted
import msky.dc.recruitment.auditlogpresenter.presenter.domain.AuditLogPresenterFacade
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class InternalEventsListener(private val facade: AuditLogPresenterFacade) {

    @EventListener
    fun handle(newAccountTypeDefined: NewAccountTypeDefined) {
        facade.handle(newAccountTypeDefined)
    }

    @EventListener
    fun handle(newCustomerRegistered: NewCustomerRegistered) {
        facade.handle(newCustomerRegistered)
    }

    @EventListener
    fun handle(newTransactionCompleted: NewTransactionCompleted) {
        facade.handle(newTransactionCompleted)
    }
}