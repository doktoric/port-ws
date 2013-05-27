package com.acme.doktoric.request;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.types.base.Event;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public interface Request {

    public Elements getResponseBody() throws IOException;

    public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException;
}
