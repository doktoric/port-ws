package com.acme.doktoric.request;

import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.enums.Category;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public abstract class AbstractRequest implements Request {

    protected final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd");
    protected final String cityId = "-1";
    protected final String countryId = "44";
    protected final String countyId = "-1";
    protected final DateTime startViewDate = StartDayOfMonth();
    protected final DateTime endViewDate = EndDayOfMonth();

    protected DateTime StartDayOfMonth() {
        return (new DateTime()).dayOfMonth().withMinimumValue();
    }

    protected DateTime EndDayOfMonth() {
        return  (new DateTime()).dayOfMonth().withMaximumValue();
    }

    protected abstract String getResponseUrl() throws IOException;

}
