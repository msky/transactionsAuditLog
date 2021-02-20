package msky.dc.recruitment.auditlogpresenter.presenter.domain

class ShowTransactionsQuery private constructor(val requestedAccountTypesIds: List<String>) {

    companion object Factory {
        fun from(commaSeparatedAccountTypesIds: String): ShowTransactionsQuery =
                ShowTransactionsQuery(commaSeparatedAccountTypesIds.split(","))
    }
}