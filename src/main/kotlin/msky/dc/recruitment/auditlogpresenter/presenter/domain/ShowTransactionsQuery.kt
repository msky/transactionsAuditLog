package msky.dc.recruitment.auditlogpresenter.presenter.domain

data class ShowTransactionsQuery private constructor(val requestedAccountTypesIds: List<String>,
                                                     val customersIds: List<String>) {

    companion object Factory {
        fun from(commaSeparatedAccountTypesIds: String,
                 commaSeparatedCustomersIds: String): ShowTransactionsQuery {

            val requestedAccountTypesIds = resolveRequiredIds(commaSeparatedAccountTypesIds)
            val requestedCustomerIds = resolveRequiredIds(commaSeparatedCustomersIds)

            return ShowTransactionsQuery(requestedAccountTypesIds,
                    requestedCustomerIds)
        }

        private fun resolveRequiredIds(commaSeparatedIds: String): List<String> {
            return if (isFilterIrrelevant(commaSeparatedIds)) {
                emptyList()
            } else {
                commaSeparatedIds.split(",")
            }
        }

        private fun isFilterIrrelevant(requestedIds: String): Boolean =
                "ALL" == requestedIds
    }
}