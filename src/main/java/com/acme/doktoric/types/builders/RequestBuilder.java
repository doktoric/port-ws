package com.acme.doktoric.types.builders;

import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;

import org.joda.time.DateTime;

import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;

public class RequestBuilder {
	public String baseUrl;
	public Category category;
	public DateType toDate;
	public DateType fromDate;
	
	public RequestBuilder withBaseUrl(WebPages baseUrl) {
		this.baseUrl=baseUrl.getUrl();
		return this;
	}
	
	public RequestBuilder withToDate(ToDate toDate) {
		this.toDate=toDate;
		return this;
	}

	public RequestBuilder withToDate(DateTime toDate) {
		this.toDate=toDate(toDate);
		return this;
	}

	public RequestBuilder withFromDate(FromDate fromDate) {
		this.fromDate=fromDate;
		return this;
	}
	
	public RequestBuilder withFromDate(DateTime fromDate) {
		this.fromDate=fromDate(fromDate);
		return this;
	}

	public RequestBuilder withCategory(Category category) {
		this.category=category;
		return this;
	}

	public static RequestBuilder create() {
		return new RequestBuilder();
	}

}
