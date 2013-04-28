package com.acme.doktoric.types.base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;

public class EventRequest {

	protected String baseUrl;
	protected Category category;
	protected Date startViewDate = EndDayOfMonth();
	protected Date endViewDate = StartDayOfMonth();
	protected ToDate toDate;
	protected FromDate fromDate;
	protected String cityId = "-1";
	protected String countryId = "44";
	protected String countyId = "-1";
	protected String topicId = "19";

	public static Date StartDayOfMonth() {

		Date actual=null ;
		SimpleDateFormat viewDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			actual=viewDateFormat.parse("2013-04-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(actual.toString());
		return actual;
	}

	
	
	public static Date EndDayOfMonth() {

		Date actual=null ;
		SimpleDateFormat viewDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			actual=viewDateFormat.parse("2013-04-30");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(actual.toString());
		return actual;
	}

	public Document getResponse() throws IOException {
		String responseUrl = getResponseUrl();
		Document doc = Jsoup.connect(responseUrl).get();
		return doc;
	}

	public String getResponseUrl() throws IOException {
		SimpleDateFormat viewDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		StringBuilder url = new StringBuilder();
		url.append(baseUrl).append(category.getUrl()).append("i_city_id=")
				.append(cityId).append("&").append("i_county_id=")
				.append(countyId).append("&").append("i_cntry_id=")
				.append(countryId).append("&").append("i_topic_id=")
				.append(topicId).append("&").append("i_selected_date=")
				.append(topicId).append("&").append("i_view_date=")
				.append(viewDateFormat.format(startViewDate)).append("-")
				.append(viewDateFormat.format(endViewDate)).append("&")
				.append("i_selected_date=")
				.append(viewDateFormat.format(fromDate.getDate())).append("-")
				.append(viewDateFormat.format(toDate.getDate()));
		return url.toString();
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getStartViewDate() {
		return startViewDate;
	}

	public void setStartViewDate(Date startViewDate) {
		this.startViewDate = startViewDate;
	}

	public Date getEndViewDate() {
		return endViewDate;
	}

	public void setEndViewDate(Date endViewDate) {
		this.endViewDate = endViewDate;
	}

	public ToDate getToDate() {
		return toDate;
	}

	public void setToDate(ToDate toDate) {
		this.toDate = toDate;
	}

	public FromDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(FromDate fromDate) {
		this.fromDate = fromDate;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

}
