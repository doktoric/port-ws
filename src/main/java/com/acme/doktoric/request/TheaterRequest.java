package com.acme.doktoric.request;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.types.base.Event;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * example: http://port.hu/pls/w/theatre.date_body?i_city_id=-1&i_county_id=-1&i_country_id=44&i_topic_id=4&i_selected_date=2013-06-01-2013-06-01&i_view_date=2013-05-01-2013-06-30
 */
public class TheaterRequest extends AbstractRequest {
    @Override
    public Elements getResponseBody() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
