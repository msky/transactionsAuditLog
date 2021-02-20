package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted

import java.time.LocalDateTime

class SampleNewTransactionCompletedEvents {
    public static NEW_TRANSACTION_COMPLETED = new NewTransactionCompleted("777",
            new BigDecimal("243.33"),
            "1",
            "1",
            LocalDateTime.parse("2013-08-04T23:57:38"))
}