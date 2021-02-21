package msky.dc.recruitment.auditlogpresenter.presenter.infra.endpoint.rest.v1

import msky.dc.recruitment.auditlogpresenter.presenter.domain.AuditLogPresenterFacade
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.util.LinkedMultiValueMap
import spock.lang.Specification

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_ID
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.JAN_NOWAK_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleShowTransactionsQueries.*
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsLogs.JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsLogs.JAN_NOWAK_SAVING_ACCOUNT_TRANSACTIONS
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TransactionsAuditLogController)
class TransactionsAuditLogControllerSpec extends Specification {

    @SpringBean
    AuditLogPresenterFacade auditLogFacade = Mock()

    @Autowired
    MockMvc mvc

    @WithMockUser
    def "query parameters should be correctly mapped to query object and passed to facade"() {
        given: "facade returns proper transactions based on the query"
            auditLogFacade.showTransactions(expectedQuery) >> expectedTransactionsLog

        when: "we call an endpoint with query parameters"
            def queryParameters = new LinkedMultiValueMap()
            queryParameters.put("customer_id", [customer_id_queryParam])
            queryParameters.put("account_type", [account_type_queryParam])

            def response = mvc.perform(get("/v1/auditlog").queryParams(queryParameters))

        then: "transactions are properly deserialized and returned"
            response.andExpect(status().isOk())

        where:
            customer_id_queryParam | account_type_queryParam | expectedQuery                                         | expectedTransactionsLog
            "1,2"                  | "1,2"                   | SHOW_JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS | JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
            "2"                    | ""                      | SHOW_ALL_JAN_NOWAK_TRANSACTIONS                       | JAN_NOWAK_SAVING_ACCOUNT_TRANSACTIONS
            "ALL"                  | "ALL"                   | SHOW_ALL_TRANSACTIONS                                 | JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
    }

    @WithMockUser
    def "transactions should be properly deserialized"() {
        given: "facade returns proper transactions based on the query"
            auditLogFacade.showTransactions(SHOW_ALL_TRANSACTIONS) >> JAN_NOWAK_SAVING_ACCOUNT_TRANSACTIONS

        when: "we call an endpoint without specified query parameters"
            def response = mvc.perform(get("/v1/auditlog"))

        then: "transactions are properly deserialized and returned"
            response.andExpect(status().isOk())
                    .andExpect(jsonPath('$[0].transactionId').value(JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_ID))
                    .andExpect(jsonPath('$[0].transactionAmount').value(JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED.transactionAmount))
                    .andExpect(jsonPath('$[0].accountTypeName').value(SAVING_ACCOUNT_TYPE_DEFINED.name))
                    .andExpect(jsonPath('$[0].customerFirstName').value(JAN_NOWAK_REGISTERED.firstName))
                    .andExpect(jsonPath('$[0].customerLastName').value(JAN_NOWAK_REGISTERED.lastName))
    }
}
