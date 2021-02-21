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

    public static ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted(
            ANDRZEJ_KOWALSKI_SAVING_ACCOUNT_TRANSACTION_ID,
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

    public static ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted(
            ANDRZEJ_KOWALSKI_10_UNITS_AMOUNT_TRANSACTION_ID,
            new BigDecimal("10"),
            CURRENCY_ACCOUNT_TYPE_ID,
            ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            LocalDateTime.parse("2013-08-04T23:57:38"))

    public static ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted(
            ANDRZEJ_KOWALSKI_100_UNITS_AMOUNT_TRANSACTION_ID,
            new BigDecimal("100"),
            CURRENCY_ACCOUNT_TYPE_ID,
            ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            LocalDateTime.parse("2015-01-01T13:17:55"))

    public static JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_COMPLETED = new NewTransactionCompleted(
            JAN_NOWAK_SAVING_ACCOUNT_TRANSACTION_ID,
            new BigDecimal("998.33"),
            SAVING_ACCOUNT_TYPE_ID,
            JAN_NOWAK_CUSTOMER_ID,
            LocalDateTime.parse("2020-12-04T03:57:38"))
}