package msky.dc.recruitment.auditlogpresenter.shared

interface EventBus {
    fun publish(event: Any)
}