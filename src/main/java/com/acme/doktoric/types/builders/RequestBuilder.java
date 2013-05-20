package com.acme.doktoric.types.builders;

import static com.acme.doktoric.types.concrete.FromDate.*;
import static com.acme.doktoric.types.concrete.ToDate.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;


import com.acme.doktoric.tags.PortRequest;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;

public class RequestBuilder {
	private static PortRequest eventRequest;
	
	public RequestBuilder withBaseUrl(WebPages baseUrl) {
		eventRequest.setBaseUrl(baseUrl.getUrl());
		return this;
	}
	
	public RequestBuilder withToDate(ToDate toDate) {
		eventRequest.setToDate(toDate);
		return this;
	}

	public RequestBuilder withToDate(DateTime toDate) {
		eventRequest.setToDate(toDate(toDate));
		return this;
	}

	public RequestBuilder withFromDate(FromDate fromDate) {
		eventRequest.setFromDate(fromDate);
		return this;
	}
	
	public RequestBuilder withFromDate(DateTime fromDate) {
		eventRequest.setFromDate(fromDate(fromDate));
		return this;
	}

	public RequestBuilder withCategory(Category category) {
		eventRequest.setCategory(category);
		return this;
	}

	public static RequestBuilder create() {
		eventRequest=new PortRequest();
		return new RequestBuilder();
	}

	public PortRequest build() {
		return eventRequest;
	}

}
