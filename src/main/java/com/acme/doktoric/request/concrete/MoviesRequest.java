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
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

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
public class MoviesRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final DateTime startViewDate = EndDayOfMonth();
    private final DateTime endViewDate = StartDayOfMonth();
    private final DateTimeFormatter formatter = DateTimeFormat
            .forPattern("YYYY-MM-dd");
    private final String itimeintervall = "0";
    private final String countryId = "44";
    private final String countyId = "-1";
    private final String cityId = "3372";
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
                .append("i_city_id=").append(cityId).append("&")
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static MoviesRequest moviesRequest(RequestBuilder builder) {
        return new MoviesRequest(builder);
    }


}
