package com.acme.doktoric.request.concrete;

import com.acme.doktoric.request.AbstractRequest;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.response.concrete.ExhibitionResponse.exhibitionResponse;

public class ExhibitionRequest extends AbstractRequest {

    private final String baseUrl;
    private final Category category;
    private final DateType toDate;
    private final DateType fromDate;
    private final String sections = "EXto";
    private final Boolean viewPermanent = false;

    public ExhibitionRequest(RequestBuilder builder) {
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
                .append("i_view_permanent=").append(viewPermanent).append("&")
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

    public List<Event> getResponse() throws IOException {
        return exhibitionResponse(getResponseBody()).process();
    }

    public Elements getResponseBody() throws IOException {
        Elements boxDiv1 = getDocument().select(".e_box .e_title_box2>a, .e_title_box2> .e_title2, .e_box .e_org_box2, .e_box .e_date2");

        return boxDiv1;
    }

    public static ExhibitionRequest exhibitionRequest(RequestBuilder builder) {
        return new ExhibitionRequest(builder);
    }

}
