package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.customers

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Customer
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MongoDbCustomerRepositoryAdapter(@Autowired private val mongoRepository: MongoDbCustomerRepository) : CustomerRepository {
    override fun save(customer: Customer) {
        mongoRepository.save(customer)
    }

    override fun findOrThrow(customerId: String): Customer {
        return mongoRepository.findById(customerId).orElseThrow { RuntimeException("Customer with id $customerId was not found") }
    }
}