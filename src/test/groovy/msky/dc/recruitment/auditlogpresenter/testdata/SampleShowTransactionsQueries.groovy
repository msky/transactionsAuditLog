package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.*

class SampleShowTransactionsQueries {
    public static ShowTransactionsQuery SHOW_ALL_TRANSACTIONS_ON_CURRENCY_ACCOUNTS_QUERY
            = new ShowTransactionsQuery([CURRENCY_ACCOUNT_TYPE_ID], [])

    public static ShowTransactionsQuery SHOW_ALL_TRANSACTIONS
            = new ShowTransactionsQuery([], [])

    public static ShowTransactionsQuery SHOW_ALL_JAN_NOWAK_TRANSACTIONS
            = new ShowTransactionsQuery([], [JAN_NOWAK_CUSTOMER_ID])

    public static ShowTransactionsQuery SHOW_JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS
            = new ShowTransactionsQuery([SAVING_ACCOUNT_TYPE_ID, CURRENCY_ACCOUNT_TYPE_ID],
            [ANDRZEJ_KOWALSKI_CUSTOMER_ID, JAN_NOWAK_CUSTOMER_ID])
}
