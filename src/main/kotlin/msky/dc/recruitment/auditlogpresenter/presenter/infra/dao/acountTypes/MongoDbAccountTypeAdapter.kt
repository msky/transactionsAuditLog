package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.acountTypes

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.AccountType
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.AccountTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MongoDbAccountTypeAdapter(@Autowired private val mongoRepository: MongoDbAccountTypeRepository) : AccountTypeRepository {
    override fun save(accountType: AccountType) {
        mongoRepository.save(accountType)
    }

    override fun findOrThrow(accountTypeId: String): AccountType {
        return mongoRepository.findById(accountTypeId)
                .orElseThrow { RuntimeException("AccountType with id $accountTypeId was not found") }
    }
}