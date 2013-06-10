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

import static com.acme.doktoric.response.concrete.BookResponse.bookResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * example: http://port.hu/pls/w/event_topic.create_events?
 * i_sections=BOdo&
 * i_topic_id=58&
 * i_selected_date=2013-05-31-2013-05-31&
 * i_view_date=2013-05-01-2013-05-31
 */
public class BookRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String isections = "BOto";
    private final String i_topic_id = "58";

    public BookRequest(RequestBuilder builder) {
        this.baseUrl = builder.baseUrl;
        this.category = builder.category;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    public Elements getResponseBody() throws IOException {
        Elements boxDiv1 =  getDocument().select(".e_title_box2, .e_org_box2, .e_date2");
        return boxDiv1;
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return bookResponse(getResponseBody()).process();
    }

    @Override
    protected String getResponseUrl() throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(category.getUrl())
                .append("i_sections=").append(isections).append("&")
                .append("i_selected_date=")
                .append(formatter.print(fromDate.getDate()))
                .append("-")
                .append(formatter.print(toDate.getDate())).append("&")
                .append("i_view_date=")
                .append(formatter.print(startViewDate))
                .append("-")
                .append(formatter.print(endViewDate)).append("&")
                .append("i_topic_id=").append(i_topic_id)
        ;
        return url.toString();
    }

    public static BookRequest bookRequest(RequestBuilder builder) {
        return new BookRequest(builder);
    }
}
