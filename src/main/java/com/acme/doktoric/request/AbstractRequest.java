package com.acme.doktoric.request;

import com.acme.doktoric.response.Response;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class AbstractRequest implements Request {

    protected final Logger logger = LoggerFactory.getLogger(Response.class);
    protected final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd");
    protected final String cityId = "-1";
    protected final String countryId = "44";
    protected final String countyId = "-1";
    protected final DateTime startViewDate = StartDayOfMonth();
    protected final DateTime endViewDate = EndDayOfMonth();

    protected DateTime StartDayOfMonth() {
        return (new DateTime()).dayOfMonth().withMinimumValue();
    }

    protected Document getDocument() throws IOException {
        String responseUrl = getResponseUrl();
        logger.info(responseUrl);
        return Jsoup.connect(responseUrl).timeout(10 * 1000).get();
    }

    protected DateTime EndDayOfMonth() {
        return (new DateTime()).dayOfMonth().withMaximumValue();
    }

    protected abstract String getResponseUrl() throws IOException;

}
