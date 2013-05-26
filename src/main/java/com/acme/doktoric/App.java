package com.acme.doktoric;

import static com.acme.doktoric.request.ExhibitionRequest.exhibitionRequest;
import static com.acme.doktoric.request.FestivalRequest.festivalRequest;
import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.request.ExhibitionRequest;
import com.acme.doktoric.request.FestivalRequest;
import com.acme.doktoric.response.Response;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;


/**
 * Hello world!
 * 
 */
public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(Response.class);

	
	public static void main(String[] args) throws IOException, UnsupportedRequestTypeException {
		
//		RequestBuilder builder=RequestBuilder.create()
//				.withBaseUrl(WebPages.PORT)
//				.withCategory(Category.FESTIVAL)
//				.withFromDate(fromDate("2013-04-01"))
//				.withToDate(toDate("2013-04-30"));
//		List<Event> festivals=festivalRequest(builder).getResponse();
		
		RequestBuilder builder1=RequestBuilder.create()
				.withBaseUrl(WebPages.PORT)
				.withCategory(Category.EXHIBITION)
				.withFromDate(fromDate("2013-05-20"))
				.withToDate(toDate("2013-05-20"));
		List<Event> exhibitions=exhibitionRequest(builder1).getResponse();
		
//		for (Event festival : festivals) {
//			logger.info(festival.toString());
//		}
	}	

//	private static void parseMainPage() throws IOException {
//		System.out.println("Kiemeltek");
//		Document doc = Jsoup.connect("http://port.hu/pls/fe/festival.index2")
//				.get();
//		Elements boxDiv = doc.select("#web_list_box_22>.background_color p b");
//		System.out.println("--------------------------------");
//		for (Element element : boxDiv) {
//			System.out.println(element.text());
//
//		}
//		System.out.println("################################");
//		System.out.println("Most Zajlok");
//		Elements nowComes = doc
//				.select(".box_border>table .white>table:nth-child(2)>tbody>tr:nth-child(4) a");
//		Elements dates = doc
//				.select(".box_border>table .white>table:nth-child(2)>tbody>tr:nth-child(4) span");
//		for (int i = 0; i < nowComes.size(); i++) {
//			System.out.println(nowComes.get(i).text() + "  "
//					+ dates.get(i).text());
//		}
//	}
}
