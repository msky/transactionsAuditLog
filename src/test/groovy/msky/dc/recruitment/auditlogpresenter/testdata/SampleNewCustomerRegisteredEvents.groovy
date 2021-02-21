package msky.dc.recruitment.auditlogpresenter.testdata

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewCustomerRegistered

import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.ANDRZEJ_KOWALSKI_CUSTOMER_ID
import static msky.dc.recruitment.auditlogpresenter.testdata.SampleIdentifiers.JAN_NOWAK_CUSTOMER_ID

class SampleNewCustomerRegisteredEvents {
    public static ANDRZEJ_KOWALSKI_REGISTERED = new NewCustomerRegistered(ANDRZEJ_KOWALSKI_CUSTOMER_ID,
            "Andrzej", "Kowalski")

    public static JAN_NOWAK_REGISTERED = new NewCustomerRegistered(JAN_NOWAK_CUSTOMER_ID,
            "Andrzej", "Kowalski")
}
