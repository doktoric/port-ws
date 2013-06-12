package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class TheaterResponse extends AbstractResponse {

    private final Elements elements;

    private TheaterResponse(Elements elements) {
        super();
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size() - 1; i = +2) {
            events.add(parse(elements.get(i)));
        }
        return events;
    }

    protected Event parse(Element element) {
        logger.info(element.toString());
        EventBuilder builder = EventBuilder.create();
        builder.withEventCategory(Category.THEATER);
        return event(builder);
    }

    public static final TheaterResponse theaterResponse(Elements elements) {
        return new TheaterResponse(elements);
    }
}
