package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Customer
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.CustomerRepository
import java.util.concurrent.ConcurrentHashMap

class InMemoryCustomerRepository(private val customersByIds: MutableMap<String, Customer> = ConcurrentHashMap()) : CustomerRepository {
    override fun save(customer: Customer) {
        customersByIds[customer.id] = customer
    }

    override fun findOrThrow(customerId: String): Customer {
        return customersByIds.getValue(customerId)
    }
}