package msky.dc.recruitment.auditlogpresenter.presenter.infra.endpoint.rest.v1

import msky.dc.recruitment.auditlogpresenter.presenter.domain.AuditLogPresenterFacade
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.util.LinkedMultiValueMap
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.SHOW_JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsLogs.JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TransactionsAuditLogController)
class TransactionsAuditLogControllerTest extends Specification {

    @SpringBean
    AuditLogPresenterFacade auditLogFacade = Mock()

    @Autowired
    MockMvc mvc

    def "query parameters should be correctly mapped to query object and passed to facade"() {
        given: "facade returns proper transactions based on the query"
            auditLogFacade.showTransactions(expectedQuery) >> expectedTransactionsLog

        when: "we call an endpoint with query parameters"
            def queryParameters = new LinkedMultiValueMap()
            queryParameters.put("customer_id", [customer_id_queryParam])
            queryParameters.put("account_type", [account_type_queryParam])

            def response = mvc.perform(get("/api/v1/auditLog/").queryParams(queryParameters))

        then: "transactions are properly deserialized and returned"
            response.andExpect(status().isOk())

        where:
            customer_id_queryParam | account_type_queryParam | expectedQuery                                         | expectedTransactionsLog
            "1,2"                  | "1,2"                   | SHOW_JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS | JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS

    }
}
