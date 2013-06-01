package com.acme.doktoric.base;

import com.acme.doktoric.request.concrete.FestivalRequest;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;

public class EventRequestTest {

    private FestivalRequest underTest;
    private String exceptedUrl = "http://port.hu/pls/fe/festival.festival_list?i_city_id=-1&i_county_id=-1&i_cntry_id=44&i_topic_id=19&i_selected_date=19&i_view_date=2013-04-30-2013-04-01&i_selected_date=2013-04-01-2013-04-30";

    @Before
    public void setUp() {
        RequestBuilder builder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.FESTIVAL)
                .withFromDate(fromDate("2013-04-01"))
                .withToDate(toDate("2013-05-30"));
        underTest = FestivalRequest.festivalRequest(builder);
    }

    @Test
    public void TestingResponseUrlWithDefaultValues() throws IOException {
        // String returnUrl = underTest.getResponseUrl();
        // Assert.assertEquals(exceptedUrl, returnUrl);
    }

}
