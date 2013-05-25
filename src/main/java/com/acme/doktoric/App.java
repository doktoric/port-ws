package com.acme.doktoric;

import static com.acme.doktoric.tags.FestivalResponse.festivalResponse;
import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.tags.FestivalResponse;
import com.acme.doktoric.tags.SimplePortRequest;
import com.acme.doktoric.tags.PortResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;


/**
 * Hello world!
 * 
 */
public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(PortResponse.class);

	
	public static void main(String[] args) throws IOException, UnsupportedRequestTypeException {
		
		RequestBuilder builder=RequestBuilder.create()
				.withBaseUrl(WebPages.PORT)
				.withCategory(Category.FESTIVAL)
				.withFromDate(fromDate("2013-04-01"))
				.withToDate(toDate("2013-04-30"));
		
		List<Event> festivals=SimplePortRequest.simplePortRequest(builder).getResponse();
		
		for (Event festival : festivals) {
			logger.info(festival.toString());
		}
	}	

	private static void parseMainPage() throws IOException {
		System.out.println("Kiemeltek");
		Document doc = Jsoup.connect("http://port.hu/pls/fe/festival.index2")
				.get();
		Elements boxDiv = doc.select("#web_list_box_22>.background_color p b");
		System.out.println("--------------------------------");
		for (Element element : boxDiv) {
			System.out.println(element.text());

		}
		System.out.println("################################");
		System.out.println("Most Zajlok");
		Elements nowComes = doc
				.select(".box_border>table .white>table:nth-child(2)>tbody>tr:nth-child(4) a");
		Elements dates = doc
				.select(".box_border>table .white>table:nth-child(2)>tbody>tr:nth-child(4) span");
		for (int i = 0; i < nowComes.size(); i++) {
			System.out.println(nowComes.get(i).text() + "  "
					+ dates.get(i).text());
		}
	}
}
