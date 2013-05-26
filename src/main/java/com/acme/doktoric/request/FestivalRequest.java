package com.acme.doktoric.tags;

import static com.acme.doktoric.tags.FestivalResponse.festivalResponse;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.types.base.DateType;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;

public class SimplePortRequest implements PortRequest{

	private final String baseUrl;
	private final Category category;
	private final DateTime startViewDate = EndDayOfMonth();
	private final DateTime endViewDate = StartDayOfMonth();
	private final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd");
	private final DateType toDate;
	private final DateType fromDate;
	private final String cityId = "-1";
	private final String countryId = "44";
	private final String countyId = "-1";
	private final String topicId = "19";

	
	
	private SimplePortRequest(RequestBuilder builder) {
		this.baseUrl=builder.baseUrl;
		this.category=builder.category;
		this.fromDate=builder.fromDate;
		this.toDate=builder.toDate;
	}

	private DateTime StartDayOfMonth() {
		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat.forPattern("YYYY-MM-dd");
		actual = viewDateFormat.parseDateTime("2013-04-01");
		return actual;
	}

	private DateTime EndDayOfMonth() {
		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat.forPattern("YYYY-MM-dd");
		actual = viewDateFormat.parseDateTime("2013-04-30");
		return actual;
	}

	public String getResponseUrl() throws IOException {
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
	
	public Elements getResponseBody() throws IOException {
		String responseUrl = getResponseUrl();
		Document doc = Jsoup.connect(responseUrl).get();
		Elements boxDiv1 = doc
				.select(".main-container table:nth-child(3) tr.gray");
		Elements boxDiv2 = doc
				.select(".main-container table:nth-child(3) tr.lightgray");
		boxDiv1.addAll(boxDiv2);
		return boxDiv1;

	}
	
	public List<Event> getResponse() throws IOException, UnsupportedRequestTypeException {
		switch(category){
		case FESTIVAL:
			return festivalResponse(getResponseBody()).process();
		case BOOK:
		case CHILD:
		case MOVIES:
		case MUSIC:
		case RESTAURANT:
		case THEATER:
		default:
			throw new UnsupportedRequestTypeException(category);
		
		}
	}

	public static SimplePortRequest simplePortRequest(RequestBuilder builder){
		return new SimplePortRequest(builder);
	}

	

}
