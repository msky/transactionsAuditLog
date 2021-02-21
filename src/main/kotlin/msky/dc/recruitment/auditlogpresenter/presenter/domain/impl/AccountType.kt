package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import org.springframework.data.annotation.Id

data class AccountType(@Id val id: String, val name: String) {
}