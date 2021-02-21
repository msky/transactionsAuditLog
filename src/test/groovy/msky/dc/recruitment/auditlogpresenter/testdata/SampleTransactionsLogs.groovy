package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionsLogDto

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleTransactionsDtos.*

class SampleTransactionsLogs {

    public static TransactionsLogDto JAN_AND_ANDRZEJ_SAVING_AND_CURRENCY_TRANSACTIONS =
            new TransactionsLogDto(
                    [
                            ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_VIEW,
                            ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW,
                            JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_VIEW
                    ]
            )
}
