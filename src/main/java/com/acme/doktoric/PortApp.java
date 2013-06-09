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
import static com.acme.doktoric.request.concrete.MoviesRequest.moviesRequest;
import static com.acme.doktoric.request.concrete.MusicRequest.musicRequest;
import static com.acme.doktoric.request.concrete.TheaterRequest.theaterRequest;
import static com.acme.doktoric.types.concrete.EventEndDate.eventEndDate;
import static com.acme.doktoric.types.concrete.EventStartDate.eventStartDate;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.09.
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class PortApp {

    private static final Logger logger = LoggerFactory.getLogger(Response.class);

    public PortApp()  {
        try {
            getMovies();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedRequestTypeException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private void getMovies() throws IOException, UnsupportedRequestTypeException {
        RequestBuilder moviesBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.MOVIES)
                .withFromDate(eventStartDate("2013-06-07"))
                .withToDate(eventEndDate("2013-06-08"));
        List<Event> movies = moviesRequest(moviesBuilder).getResponse();
        for (Event movie : movies) {
            logger.info(movie.toString());
        }
    }

    private void getTheaters() throws IOException, UnsupportedRequestTypeException {
        RequestBuilder theaterBuilder = RequestBuilder.create()
                .withBaseUrl(WebPages.PORT)
                .withCategory(Category.THEATER)
                .withFromDate(eventStartDate("2013-06-01"))
                .withToDate(eventEndDate("2013-06-30"));
        List<Event> theaters = theaterRequest(theaterBuilder).getResponse();
    }

    private void getBooks() throws IOException, UnsupportedRequestTypeException {
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

    private void getChild() throws IOException, UnsupportedRequestTypeException {
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

    private void getMusic() throws IOException, UnsupportedRequestTypeException {
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

    private void getExhibitions() throws IOException {
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


}
