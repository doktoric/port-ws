package com.acme.doktoric.response.concrete;

import com.acme.doktoric.response.AbstractResponse;
import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static com.acme.doktoric.types.base.Event.event;
import static com.acme.doktoric.types.concrete.EventEndDate.eventEndDate;
import static com.acme.doktoric.types.concrete.EventStartDate.eventStartDate;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.05.28.
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class MoviesResponse extends AbstractResponse {

    private final Elements elements;
    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm");

    private MoviesResponse(Elements elements) {
        super();
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < elements.size() - 1; i += 2) {
            String place = rowProvider.getRow(elements.get(i).text());
            String description = rowProvider.getRow(elements.get(i + 1).text());
            parseLine(events, place, description);
        }
        return events;
    }

    private void parseLine(List<Event> events, String eventPlace, String eventDescripton) {
        EventBuilder builder = EventBuilder.create();
        if (isParsable(eventDescripton)) {
            try {
                builder.withEventName(eventPlace);
                String[] parts = eventDescripton.split(DAYS);
                builder.withEventPlace(parts[0]);
                eventDescripton = eventDescripton.replace(parts[0], "").trim();
                parts = eventDescripton.split("\\)");
                String date = getDate(parts[0].replace("(", "").replace(")", "").trim());
                parts = eventDescripton.trim().split(DAYS, -1);
                for (int i = 0; i < parts.length; i++) {
                    String s = parts[i];
                    if (!s.equals("")) {
                        String dateTmp = s.replaceAll("\\(.*\\)", "").trim();
                        String[] dates = dateTmp.split(" ");
                        for (int j = 1; j < dates.length; j++) {
                            if (!dates[j].trim().equals("")) {
                                events.add(parse(builder, date, dates[j].trim()));
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + eventDescripton);
            }
        }

    }

    public static final MoviesResponse moviesResponse(Elements elements) {
        return new MoviesResponse(elements);
    }

    protected Event parse(EventBuilder builder, String date, String dateHour) {
        String tmp = date + " " + dateHour;
        builder.withStartDate(eventStartDate(formatter.parseDateTime(tmp)));
        builder.withEndDate(eventEndDate(formatter.parseDateTime(tmp)));
        return event(builder);
    }

    private String getDate(String monthAndDay) {
        String[] dayAsString = monthAndDay.split(" ");
        monthAndDay = monthAndDay.replace(dayAsString[0], "");
        monthAndDay = monthAndDay.replace(DAYS, "").trim();
        int year = (new DateTime()).getYear();
        String[] monthAsString = monthAndDay.split(" ");
        int month = BIG_CAPITAL_MONTHS.indexOf(monthAsString[0]) + 1;
        String day = monthAsString[1].replace(".", "").trim();
        return year + "-" + month + "-" + day;
    }

}
