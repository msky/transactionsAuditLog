package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.CURRENCY_ACCOUNT_TYPE_ID

class SampleShowTransactionsQueries {
    public static ShowTransactionsQuery SHOW_ALL_TRANSACTIONS_ON_CURRENCY_ACCOUNTS_QUERY
            = new ShowTransactionsQuery([CURRENCY_ACCOUNT_TYPE_ID])

    public static ShowTransactionsQuery SHOW_TRANSACTIONS_WITH_ANY_ACCOUNT_TYPE
            = new ShowTransactionsQuery([])
}
