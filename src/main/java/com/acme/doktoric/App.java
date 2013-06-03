package com.acme.doktoric;

import com.acme.doktoric.exceptions.UnsupportedRequestTypeException;
import com.acme.doktoric.response.Response;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.RequestBuilder;
import com.acme.doktoric.types.enums.Category;
import com.acme.doktoric.types.enums.WebPages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.acme.doktoric.request.concrete.BookRequest.bookRequest;
import static com.acme.doktoric.request.concrete.ChildRequest.childRequest;
import static com.acme.doktoric.request.concrete.ExhibitionRequest.exhibitionRequest;
import static com.acme.doktoric.request.concrete.MusicRequest.musicRequest;
import static com.acme.doktoric.types.concrete.EventEndDate.eventEndDate;
import static com.acme.doktoric.types.concrete.EventStartDate.eventStartDate;


/**
 * Generated by Doktoric
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(Response.class);


    public static void main(String[] args) throws IOException, UnsupportedRequestTypeException {
          getMusic();
        //getExhibitions();
        //getChild();
        //getBooks();
    }

    private static void getBooks() throws IOException, UnsupportedRequestTypeException {
        RequestBuilder bookBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.BOOK)
                .withFromDate(eventStartDate("2013-06-02"))
                .withToDate(eventEndDate("2013-06-04"));
        List<Event> books = bookRequest(bookBuilder).getResponse();

        for (Event book : books) {
            logger.info(book.toString());
        }
    }

    private static void getChild() throws IOException, UnsupportedRequestTypeException {
        RequestBuilder childBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.CHILD)
                .withFromDate(eventStartDate("2013-06-02"))
                .withToDate(eventEndDate("2013-06-04"));
        List<Event> children = childRequest(childBuilder).getResponse();

        for (Event child : children) {
            logger.info(child.toString());
        }
    }

    private static void getMusic() throws IOException, UnsupportedRequestTypeException {
        RequestBuilder musicBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.MUSIC)
                .withFromDate(eventStartDate("2013-06-02"))
                .withToDate(eventEndDate("2013-06-04"));
        List<Event> musics = musicRequest(musicBuilder).getResponse();

        for (Event music : musics) {
            logger.info(music.toString());
        }
    }

    private static void getExhibitions() throws IOException {
        RequestBuilder exhibitonBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.EXHIBITION)
                .withFromDate(eventStartDate("2013-05-20"))
                .withToDate(eventEndDate("2013-05-20"));
        List<Event> exhibitions = exhibitionRequest(exhibitonBuilder).getResponse();

        for (Event exhibition : exhibitions) {
            logger.info(exhibition.toString());
        }
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
