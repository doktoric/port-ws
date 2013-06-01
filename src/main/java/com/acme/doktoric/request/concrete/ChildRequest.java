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

import static com.acme.doktoric.response.concrete.ChildResponse.childResponse;
import static com.acme.doktoric.response.concrete.MoviesResponse.moviesResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * example: http://port.hu/pls/w/child.event_list?
 * i_city_id=-1
 * &i_county_id=-1
 * &i_country_id=44
 * &i_topic_id=25
 * &i_age_limit_from=,5
 * &i_age_limit_to=14
 * &i_selected_date=2013-06-01-2013-06-01
 * &i_view_date=2013-05-01-2013-06-30
 */
public class ChildRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final DateTime startViewDate = EndDayOfMonth();
    private final DateTime endViewDate = StartDayOfMonth();
    private final DateTimeFormatter formatter = DateTimeFormat
            .forPattern("YYYY-MM-dd");
    private final String sections = "EXto";
    private final Boolean viewPermanent = false;

    public ChildRequest(RequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.category = builder.category;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    protected String getResponseUrl() throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(category.getUrl())
                .append("i_city=").append("-1").append("&")
                .append("i_county_id=").append("-1").append("&")
                .append("i_country_id=").append("44").append("&")
                .append("i_topic_id=").append("25").append("&")
                .append("i_age_limit_from=").append(viewPermanent).append(",5").append("&")
                .append("i_age_limit_to=").append(viewPermanent).append("90").append("&")
                .append("i_selected_date=")
                .append(formatter.print(fromDate.getDate()))
                .append("-")
                .append(formatter.print(toDate.getDate())).append("&")
                .append("i_view_date=")
                .append(formatter.print(startViewDate))
                .append("-")
                .append(formatter.print(endViewDate));
        return url.toString();
    }

    @Override
    public Elements getResponseBody() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return childResponse(getResponseBody()).process();
    }

    public static ChildRequest childRequest(RequestBuilder builder) {
        return new ChildRequest(builder);
    }
}
