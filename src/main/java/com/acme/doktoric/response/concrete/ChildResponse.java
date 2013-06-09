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
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class ChildResponse extends AbstractResponse {

    private final Elements elements;

    private ChildResponse(Elements elements) {
        super();
        this.elements = elements;
    }

    protected Event parse(Element eventName, Element place, Element date) {
        EventBuilder builder = EventBuilder.create();
        builder.withEventCategory(Category.BOOK)
                .withStartDate(replaceMonthIntDateString(date.text()))
                .withEndDate(replaceMonthIntDateString(date.text()))
                .withEventName(eventName.select(".e_title2, .ltxt").text())
                .withEventPlace(place.text());
        return event(builder);
    }

    public static final ChildResponse childResponse(Elements elements) {
        return new ChildResponse(elements);
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size(); i += 3) {
            if (isParsable(rowProvider.getRow(elements.get(i).text()))) {
                events.add(parse(elements.get(i), elements.get(i + 1), elements.get(i + 2)));
            }
        }
        return events;
    }
}
