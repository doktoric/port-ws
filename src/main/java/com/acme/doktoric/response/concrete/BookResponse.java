package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class BookResponse extends AbstractResponse {

    private final Elements elements;

    private BookResponse(Elements elements) {
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static final BookResponse bookResponse(Elements elements) {
        return new BookResponse(elements);
    }

    @Override
    protected Event parse(String event) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
