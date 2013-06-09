package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;

public class MusicResponse extends AbstractResponse {

    private final Elements elements;

    private MusicResponse(Elements elements) {
        super();
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size() - 1; i = +2) {
            events.add(parse(elements.get(i), elements.get(i + 1)));
        }
        return events;
    }

    public static final MusicResponse musicResponse(Elements elements) {
        return new MusicResponse(elements);
    }

    protected Event parse(Element first, Element second) {
        logger.info(first.toString());
        logger.info(second.toString());
        EventBuilder builder = EventBuilder.create();
  //   builder.withEventCategory(Category.FESTIVAL)
   //             .withEventName(name).withEventPlace(place)
     //           .withStartDate(fromDate).withEndDate(toDate);
        return event(builder);
    }
}
