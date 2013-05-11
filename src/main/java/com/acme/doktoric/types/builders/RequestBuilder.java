package com.acme.doktoric.types.builders;

import static com.acme.doktoric.types.concrete.FromDate.*;
import static com.acme.doktoric.types.concrete.ToDate.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import com.acme.doktoric.types.base.EventRequest;

import com.acme.doktoric.types.enums.Category;

public class RequestBuilder {
	private static EventRequest eventRequest;
	
	public RequestBuilder withBaseUrl(String baseUrl) {
		eventRequest.setBaseUrl(baseUrl);
		return this;
	}
	
	public RequestBuilder withToDate(String toDate) {
		eventRequest.setToDate(toDate(toDate));
		return this;
	}

	public RequestBuilder withToDate(DateTime toDate) {
		eventRequest.setToDate(toDate(toDate));
		return this;
	}

	public RequestBuilder withFromDate(String fromDate) {
		eventRequest.setFromDate(fromDate(fromDate));
		return this;
	}

	public RequestBuilder withCategory(Category category) {
		eventRequest.setCategory(category);
		return this;
	}

	public RequestBuilder withFromDate(DateTime fromDate) {
		eventRequest.setFromDate(fromDate(fromDate));
		return this;
	}

	public static RequestBuilder create() {
		eventRequest=new EventRequest();
		return new RequestBuilder();
	}

	public EventRequest build() {
		return eventRequest;
	}

}
