package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;

public class FestivalResponse extends AbstractResponse {

    private final Elements elements;

    private FestivalResponse(Elements elements) {
        this.elements = elements;
    }

    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i).text();
            if (isParsable(element)) {
                events.add(parse(element));
            }
        }
        return events;
    }

    protected Event parse(String event) {
        EventBuilder builder = EventBuilder.create();
        try {
            String parts[] = event.split(" - ");
            String name = parts[0].trim();
            event = event.replace(name + " - ", "");
            parts = event.split("   ");
            String place = parts[0].trim();
            event = event.trim().replace(place, "").trim();
            parts = event.split("-");
            String fromDate = parts[0].replace(String.valueOf((char) 160), " ")
                    .trim();
            String toDate = "";
            if (parts.length == 2) {
                toDate = parts[1].replace(String.valueOf((char) 160), " ")
                        .trim();
                toDate = replaceMonthIntDateString(toDate);
            } else {
                toDate = replaceMonthIntDateString(fromDate);
            }
            fromDate = replaceMonthIntDateString(fromDate);

            builder.withEventCategory(Category.FESTIVAL)
                    .withEventName(name).withEventPlace(place)
                    .withFromDate(fromDate).withToDate(toDate);
        } catch (Exception ex) {
            logger.info("BAD__: " + event);
        }
        return event(builder);

    }

    public static final FestivalResponse festivalResponse(Elements elements) {
        return new FestivalResponse(elements);
    }

}
