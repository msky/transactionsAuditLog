package msky.dc.recruitment.auditlogpresenter.presenter.domain

data class ShowTransactionsQuery private constructor(val accountTypesIds: List<String>,
                                                     val customersIds: List<String>) {
    fun showAllAccounts(): Boolean {
        return accountTypesIds.isEmpty()
    }

    fun containsAccountId(accountTypeId: String): Boolean {
        return accountTypesIds.contains(accountTypeId)
    }

    fun showAllCustomers(): Boolean {
        return customersIds.isEmpty()
    }

    fun containsCustomerId(customerId: String): Boolean {
        return customersIds.contains(customerId)
    }

    fun noFiltersAreDefined(): Boolean {
        return showAllAccounts() && showAllCustomers()
    }

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