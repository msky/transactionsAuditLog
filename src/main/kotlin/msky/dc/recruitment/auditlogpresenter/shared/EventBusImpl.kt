package msky.dc.recruitment.auditlogpresenter.shared

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class EventBusImpl(@Autowired private val springEventPublisher: ApplicationEventPublisher) : EventBus {

    override fun publish(event: Any) {
        springEventPublisher.publishEvent(event)
    }
}