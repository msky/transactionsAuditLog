package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.customers

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbCustomerRepository: MongoRepository<Customer, String>{

}
