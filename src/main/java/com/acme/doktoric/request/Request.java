package com.acme.doktoric.request;

import java.io.IOException;
import java.util.List;

import org.jsoup.select.Elements;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.types.base.Event;

public interface Request {

	public Elements getResponseBody()  throws IOException;
	public List<Event> getResponse()  throws IOException, UnsupportedRequestTypeException;
}
