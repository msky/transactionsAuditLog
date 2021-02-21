package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.acountTypes

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.AccountType
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbAccountTypeRepository : MongoRepository<AccountType, String> {
}