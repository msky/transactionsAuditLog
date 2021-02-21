package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.AccountType
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.AccountTypeRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class InMemoryAccountTypeRepository(private val accountTypesById: MutableMap<String, AccountType> = ConcurrentHashMap())
    : AccountTypeRepository {

    override fun save(accountType: AccountType) {
        accountTypesById[accountType.id] = accountType
    }

    override fun findOrThrow(accountTypeId: String): AccountType {
        return accountTypesById.getValue(accountTypeId)
    }
}