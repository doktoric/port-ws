package com.acme.doktoric.request.concrete;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.request.AbstractRequest;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.response.concrete.BookResponse.bookResponse;
import static com.acme.doktoric.response.concrete.MoviesResponse.moviesResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 * sample: http://port.hu/pls/ci/cinema.list_days?
 * i_city_id=3372&
 * i_county_id=1&
 * i_country_id=44&
 * i_dist_id=-1&
 * i_time_intervall=0&
 * i_selected_date=2013-05-25-2013-05-25&
 * i_view_date=2013-05-01-2013-05-31
 */

//TODO needed
public class MoviesRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String itimeintervall = "0";
    private final String idistid = "-1";

    private MoviesRequest(RequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.category = builder.category;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    protected String getResponseUrl() throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(category.getUrl())
                .append("i_city_id=").append("3372").append("&")
                .append("i_county_id=").append(countyId).append("&")
                .append("i_country_id=").append(countryId).append("&")
                .append("i_dist_id=").append(idistid).append("&")
                .append("i_time_intervall=").append(itimeintervall).append("&")
                .append("i_view_date=").append(formatter.print(startViewDate))
                .append("-")
                .append(formatter.print(endViewDate)).append("&")
                .append("i_selected_date=")
                .append(formatter.print(fromDate.getDate()))
                .append("-")
                .append(formatter.print(toDate.getDate()));
        return url.toString();
    }

    @Override
    public Elements getResponseBody() throws IOException {
        String responseUrl = getResponseUrl();
        Document doc = Jsoup.connect(responseUrl).get();
        Elements boxDiv1 = doc
                .select("");

        return boxDiv1;
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return moviesResponse(getResponseBody()).process();
    }

    public static MoviesRequest moviesRequest(RequestBuilder builder) {
        return new MoviesRequest(builder);
    }


}
