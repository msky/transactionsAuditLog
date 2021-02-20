package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

interface AccountTypeRepository {
    fun save(accountType: AccountType)

    fun findOrThrow(accountTypeId: String): AccountType
}