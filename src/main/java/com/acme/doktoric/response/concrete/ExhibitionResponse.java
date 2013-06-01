package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;
import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;

public class ExhibitionResponse extends AbstractResponse {

    private final Elements elements;

    public ExhibitionResponse(Elements elements) {
        this.elements = elements;
    }

    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size(); i++) {
            String title;
            String place;
            String date;
            do {
                title = elements.get(i).text();
                i++;
            } while (!isParsable(title));
            do {
                place = elements.get(i).text();
                i++;
            } while (!isParsable(place));
            do {
                date = elements.get(i).text();
                i++;
            } while (!isParsable(date));
            if (isParsable(title) && isParsable(place) && isParsable(date)) {
                events.add(parse(title + "$" + place + "$" + date));
            }
            i--;
        }
        return events;
    }

    private Event parse(String event) {
        event = event.replace(String.valueOf((char) 160), " ");
        EventBuilder builder = EventBuilder.create();
        try {
            String[] parts = event.split("\\$");
            String place = parts[1].trim();
            String name = parts[0].trim();
            String[] dates = parts[2].split(" - ");
            String fromdate = dates[0].trim();
            fromdate = replaceMonthIntDateString(fromdate);
            String todate = "";
            if (dates.length == 2) {
                todate = dates[1].trim();
                todate = replaceMonthIntDateString(todate);
            } else {
                todate = replaceMonthIntDateString(fromdate);
            }
            builder.withEventCategory(Category.FESTIVAL).withEventName(name)
                    .withEventPlace(place).withFromDate(fromDate(fromdate))
                    .withToDate(toDate(todate));
        } catch (Exception ex) {
            logger.info("BAD__: " + event);
        }
        return event(builder);
    }

    public static final ExhibitionResponse exhibitionResponse(Elements elements) {
        return new ExhibitionResponse(elements);
    }

}
