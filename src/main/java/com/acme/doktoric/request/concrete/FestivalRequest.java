package com.acme.doktoric.request.concrete;

import com.acme.doktoric.request.AbstractRequest;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.response.concrete.FestivalResponse.festivalResponse;

public class FestivalRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String topicId = "19";

    private FestivalRequest(RequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.category = builder.category;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }


    protected String getResponseUrl() throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(category.getUrl()).append("i_city_id=")
                .append(cityId).append("&").append("i_county_id=")
                .append(countyId).append("&").append("i_cntry_id=")
                .append(countryId).append("&").append("i_topic_id=")
                .append(topicId).append("&").append("i_view_date=")
                .append(formatter.print(startViewDate)).append("-")
                .append(formatter.print(endViewDate)).append("&")
                .append("i_selected_date=")
                .append(formatter.print(fromDate.getDate())).append("-")
                .append(formatter.print(toDate.getDate()));
        return url.toString();
    }

    @Override
    public Elements getResponseBody() throws IOException {
        Elements boxDiv1 = getDocument().select(".main-container table:nth-child(3) tr.gray");
        Elements boxDiv2 = getDocument().select(".main-container table:nth-child(3) tr.lightgray");
        boxDiv1.addAll(boxDiv2);
        return boxDiv1;

    }

    public List<Event> getResponse() throws IOException {
        return festivalResponse(getResponseBody()).process();
    }

    public static FestivalRequest festivalRequest(RequestBuilder builder) {
        return new FestivalRequest(builder);
    }

}
