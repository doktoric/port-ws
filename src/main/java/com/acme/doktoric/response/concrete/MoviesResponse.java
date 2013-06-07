package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class MoviesResponse extends AbstractResponse {

    private final Elements elements;

    private MoviesResponse(Elements elements) {
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size() - 1; i += 2) {
            events.add(parse(elements.get(i).text(), elements.get(i + 1).text()));
        }
        return events;
    }

    public static final MoviesResponse moviesResponse(Elements elements) {
        return new MoviesResponse(elements);
    }

    protected Event parse(String eventPlace, String eventDescripton) {
        eventPlace= eventPlace.replace(String.valueOf((char) 160), " ");
        eventDescripton= eventDescripton.replace(String.valueOf((char) 160), " ");

        EventBuilder builder=EventBuilder.create();
        builder.withEventName(eventPlace);
        String[] parts=eventDescripton.split(DAYS);
        builder.withEventPlace(parts[0]);



        logger.info(eventPlace);
        logger.info(eventDescripton);
        return event(builder);
    }
}
