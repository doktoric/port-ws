package com.acme.doktoric.types.base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;

public class EventRequest {

	protected String baseUrl;
	protected Category category;
	protected DateTime startViewDate = EndDayOfMonth();
	protected DateTime endViewDate = StartDayOfMonth();
	DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd");
	protected ToDate toDate;
	protected FromDate fromDate;
	protected String cityId = "-1";
	protected String countryId = "44";
	protected String countyId = "-1";
	protected String topicId = "19";

	private DateTime StartDayOfMonth() {

		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat
				.forPattern("YYYY-MM-dd");
		actual = viewDateFormat.parseDateTime("2013-04-01");

		System.out.println(actual.toString());
		return actual;
	}

	private DateTime EndDayOfMonth() {

		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat
				.forPattern("YYYY-MM-dd");

		actual = viewDateFormat.parseDateTime("2013-04-30");

		System.out.println(actual.toString());
		return actual;
	}

	public Document getResponse() throws IOException {
		String responseUrl = getResponseUrl();
		Document doc = Jsoup.connect(responseUrl).get();
		return doc;
	}

	public String getResponseUrl() throws IOException {
		// SimpleDateFormat viewDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		StringBuilder url = new StringBuilder();
		url.append(baseUrl).append(category.getUrl()).append("i_city_id=")
				.append(cityId).append("&").append("i_county_id=")
				.append(countyId).append("&").append("i_cntry_id=")
				.append(countryId).append("&").append("i_topic_id=")
				.append(topicId).append("&").append("i_view_date=")
				.append(formatter.print(startViewDate)).append("-")
				.append(formatter.print(endViewDate)).append("&")
				.append("i_selected_date=")
				.append(formatter.print(fromDate.getDate())).append("-")
				.append(formatter.print(toDate.getDate()));
		return url.toString();
	}

	public Elements getResponseBody(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements boxDiv1 = doc
				.select(".main-container table:nth-child(3) tr.gray");
		Elements boxDiv2 = doc
				.select(".main-container table:nth-child(3) tr.lightgray");
		boxDiv1.addAll(boxDiv2);
		return boxDiv1;

	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setToDate(ToDate toDate) {
		this.toDate = toDate;
	}

	public void setFromDate(FromDate fromDate) {
		this.fromDate = fromDate;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

}
