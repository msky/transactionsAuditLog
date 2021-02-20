package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewAccountTypeDefined

class SampleNewAccountTypeDefinedEvents {
    public static NewAccountTypeDefined SAVING_ACCOUNT_TYPE_DEFINED =
            new NewAccountTypeDefined("1", "saving account")

    public static NewAccountTypeDefined CURRENCY_ACCOUNT_TYPE_DEFINED =
            new NewAccountTypeDefined("2", "currency account")
}
