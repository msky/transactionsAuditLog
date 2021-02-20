package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

interface CustomerRepository {
    fun save(customer: Customer)

    fun findOrThrow(customerId: String): Customer
}