package com.acme.doktoric.request.concrete;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.request.AbstractRequest;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.response.concrete.ChildResponse.childResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * example: http://port.hu/pls/w/child.event_list?
 * i_sections=OTto,COto,THto,CCdc,SPdc,EXdc,CIdc,KNdc
 * &i_selected_date=2013-06-14-2013-06-15
 * &i_view_date=2013-06-01-2013-07-01
 * &i_topic_id=25
 * &i_age_limit_from=,5
 * &i_age_limit_to=99
 */
public class ChildRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String sections = "OTto,COto,THto,CCdc,SPdc,EXdc,CIdc,KNdc";
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
                .append("i_sections=").append(sections).append("&")
                .append("i_selected_date=")
                .append(formatter.print(fromDate.getDate()))
                .append("-")
                .append(formatter.print(toDate.getDate())).append("&")
                .append("i_view_date=")
                .append(formatter.print(startViewDate))
                .append("-")
                .append(formatter.print(endViewDate)).append("&")
                .append("i_topic_id=").append("25").append("&")
                .append("i_age_limit_from=").append(",5").append("&")
                .append("i_age_limit_to=").append("90");
        return url.toString();
    }

    @Override
    public Elements getResponseBody() throws IOException {
        Elements boxDiv1 = getDocument().select(".e_title_box2, .e_org_box2, .e_date2");

        return boxDiv1;
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return childResponse(getResponseBody()).process();
    }

    public static ChildRequest childRequest(RequestBuilder builder) {
        return new ChildRequest(builder);
    }
}
