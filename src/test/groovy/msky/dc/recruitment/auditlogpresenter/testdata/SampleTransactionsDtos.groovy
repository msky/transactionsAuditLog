package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.presenter.domain.TransactionDto

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.*
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.CURRENCY_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewAccountTypeDefinedEvents.SAVING_ACCOUNT_TYPE_DEFINED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewCustomerRegisteredEvents.ANDRZEJ_KOWALSKI_REGISTERED
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleNewTransactionCompletedEvents.*

class SampleTransactionsDtos {
    public static TransactionDto ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_VIEW =
            new TransactionDto(ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_ID,
                    ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED.transactionAmount,
                    ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED.transactionDate,
                    CURRENCY_ACCOUNT_TYPE_DEFINED.name,
                    ANDRZEJ_KOWALSKI_REGISTERED.firstName,
                    ANDRZEJ_KOWALSKI_REGISTERED.lastName
            )

    public static TransactionDto ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_VIEW =
            new TransactionDto(ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_ID,
                    ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED.transactionAmount,
                    ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED.transactionDate,
                    SAVING_ACCOUNT_TYPE_DEFINED.name,
                    ANDRZEJ_KOWALSKI_REGISTERED.firstName,
                    ANDRZEJ_KOWALSKI_REGISTERED.lastName
            )

    public static TransactionDto ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_VIEW =
            new TransactionDto(ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_ID,
                    ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_COMPLETED.transactionAmount,
                    ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_COMPLETED.transactionDate,
                    CURRENCY_ACCOUNT_TYPE_DEFINED.name,
                    ANDRZEJ_KOWALSKI_REGISTERED.firstName,
                    ANDRZEJ_KOWALSKI_REGISTERED.lastName)


    public static TransactionDto ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_VIEW =
            new TransactionDto(ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_ID,
                    ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_COMPLETED.transactionAmount,
                    ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_COMPLETED.transactionDate,
                    CURRENCY_ACCOUNT_TYPE_DEFINED.name,
                    ANDRZEJ_KOWALSKI_REGISTERED.firstName,
                    ANDRZEJ_KOWALSKI_REGISTERED.lastName
            )
}
