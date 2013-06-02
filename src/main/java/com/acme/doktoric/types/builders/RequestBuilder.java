package com.acme.doktoric.types.builders;

import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.concrete.EventEndDate;
import com.acme.doktoric.types.concrete.EventStartDate;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;
import org.joda.time.DateTime;

import static com.acme.doktoric.types.concrete.EventStartDate.eventStartDate;
import static com.acme.doktoric.types.concrete.EventEndDate.eventEndDate;

public class RequestBuilder {
    public String baseUrl;
    public Category category;
    public DateType toDate;
    public DateType fromDate;

    public RequestBuilder withBaseUrl(WebPages baseUrl) {
        this.baseUrl = baseUrl.getUrl();
        return this;
    }

    public RequestBuilder withToDate(EventEndDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public RequestBuilder withEndDate(DateTime toDate) {
        this.toDate = eventEndDate(toDate);
        return this;
    }

    public RequestBuilder withFromDate(EventStartDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public RequestBuilder withStartDate(DateTime fromDate) {
        this.fromDate = eventStartDate(fromDate);
        return this;
    }

    public RequestBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public static RequestBuilder create() {
        return new RequestBuilder();
    }

}
