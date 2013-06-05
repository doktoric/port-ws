package com.acme.doktoric.request.concrete;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.request.AbstractRequest;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.response.concrete.TheaterResponse.theaterResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * example: http://port.hu/pls/w/theatre.date_body?
 * i_city_id=-1&
 * i_county_id=-1&
 * i_country_id=44&
 * i_topic_id=4&
 * i_selected_date=2013-06-01-2013-06-01&
 * i_view_date=2013-05-01-2013-06-30
 */

//TODO needed
public class TheaterRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String topicId = "4";

    public TheaterRequest(RequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.category = builder.category;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    public Elements getResponseBody() throws IOException {
        String responseUrl = getResponseUrl();
        Document doc = Jsoup.connect(responseUrl).get();
        Elements boxDiv1 = doc.select(".e_box");
        return boxDiv1;
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return theaterResponse(getResponseBody()).process();
    }


    @Override
    protected String getResponseUrl() throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(category.getUrl())
                .append("i_sections=").append("THpo").append("&")
                .append("i_selected_date=").append(formatter.print(fromDate.getDate()))
                .append("-")
                .append(formatter.print(toDate.getDate())).append("&")
                .append("i_view_date=").append(formatter.print(startViewDate))
                .append("-")
                .append(formatter.print(endViewDate));
        return url.toString();
    }

    public static TheaterRequest theaterRequest(RequestBuilder builder) {
        return new TheaterRequest(builder);
    }
}
