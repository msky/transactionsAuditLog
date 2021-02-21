package msky.dc.recruitment.auditlogpresenter.presenter.domain

class ShowTransactionsQuery private constructor(val requestedAccountTypesIds: List<String>,
                                                val customersIds: List<String>) {

    companion object Factory {
        fun from(commaSeparatedAccountTypesIds: String,
                 commaSeparatedCustomersIds: String): ShowTransactionsQuery =
                ShowTransactionsQuery(commaSeparatedAccountTypesIds.split(","),
                        commaSeparatedCustomersIds.split(","))
    }
}