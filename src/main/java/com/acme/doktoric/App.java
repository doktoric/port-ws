package com.acme.doktoric;

import static com.acme.doktoric.tags.FestivalResponse.festivalResponse;
import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.acme.doktoric.tags.FestivalResponse;
import com.acme.doktoric.tags.PortRequest;
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
	public static void main(String[] args) throws IOException {
		PortRequest eventRequest=RequestBuilder.create()
				.withBaseUrl(WebPages.PORT)
				.withCategory(Category.FESTIVAL)
				.withFromDate(fromDate("2013-04-01"))
				.withToDate(toDate("2013-04-30"))
				.build();
		String url=eventRequest.getResponseUrl();
		Elements response=eventRequest.getResponseBody(url);
		
		FestivalResponse festival=festivalResponse(response);
		System.out.println(url);
		//System.out.println(festival.getElements());
				
	}
	
//	private static void parseDatePage() throws IOException {
//		System.out.println("Feszitválok adott dátumra");
//		String url="http://port.hu/pls/fe/festival.festival_list?i_city_id=-1&i_county_id=-1&i_cntry_id=44&i_topic_id=19&i_selected_date=2013-04-01-2013-04-01&i_view_date=2013-04-01-2013-04-30";
//	
//		Document doc = Jsoup.connect(url)
//				.get();
//		Elements boxDiv1 = doc.select(".main-container table:nth-child(3) tr.gray");
//		Elements boxDiv2 = doc.select(".main-container table:nth-child(3) tr.lightgray");
//		for (int i = 0; i < boxDiv1.size(); i++) {
//			System.out.println(boxDiv1.get(i).text() );
//		}
//		for (int i = 0; i < boxDiv2.size(); i++) {
//			System.out.println(boxDiv2.get(i).text() );
//		}
//		
//	}
	

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
