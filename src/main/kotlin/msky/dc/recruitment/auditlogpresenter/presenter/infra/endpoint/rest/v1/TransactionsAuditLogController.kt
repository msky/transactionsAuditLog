package msky.dc.recruitment.auditlogpresenter.presenter.infra.endpoint.rest.v1

import msky.dc.recruitment.auditlogpresenter.presenter.domain.AuditLogPresenterFacade
import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery
import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auditlog")
class TransactionsAuditLogController(@Autowired private val auditLogPresenterFacade: AuditLogPresenterFacade) {

    @GetMapping
    fun getTransactionsWithDetails(
            @RequestParam(value = "account_type", required = false, defaultValue = "ALL") commaSeparatedAccountTypesIds: String,
            @RequestParam(value = "customer_id", required = false, defaultValue = "ALL") commaSeparatedCustomersId: String)
            : ResponseEntity<List<TransactionDto>> {
        val query = ShowTransactionsQuery.from(commaSeparatedAccountTypesIds, commaSeparatedCustomersId)

        return ResponseEntity.ok(auditLogPresenterFacade.showTransactions(query).transactions)
    }

}