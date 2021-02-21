package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import org.springframework.data.annotation.Id

data class Customer(@Id val id: String, val firstName: String, val lastName: String) {
}