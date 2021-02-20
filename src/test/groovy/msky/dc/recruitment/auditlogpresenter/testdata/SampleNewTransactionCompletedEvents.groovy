package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted

import java.time.LocalDateTime

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.*

class SampleNewTransactionCompletedEvents {
    public static NEW_TRANSACTION_COMPLETED = new NewTransactionCompleted("777",
            new BigDecimal("243.33"),
            SAVING_ACCOUNT_TYPE_ID,
            ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            LocalDateTime.parse("2013-08-04T23:57:38"))

    public static ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted("129",
            new BigDecimal("128.33"),
            SAVING_ACCOUNT_TYPE_ID,
            ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            LocalDateTime.parse("2013-08-04T23:57:38"))

    public static ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted(
            ANDRZEJ_KOWALSKI_CURRENCY_ACCOUNT_TRANSACTION_ID,
            new BigDecimal("19.99"),
            CURRENCY_ACCOUNT_TYPE_ID,
            ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            LocalDateTime.parse("2013-08-04T23:57:38"))
}