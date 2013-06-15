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

public class MusicResponse extends AbstractResponse {

    private final Elements elements;

    private MusicResponse(Elements elements) {
        super();
        this.elements = elements;
    }

    @Override
    public List<Event> process() {
        List<Event> events = new ArrayList<Event>();
        for (int i = 1; i < elements.size() - 1; i++) {
            if (elements.get(i).text().equals(elements.get(i - 1).text())) {
                elements.remove(i);
                i--;
            }
        }
        for (int i = 0; i < elements.size() - 1; i = i + 2) {
            logger.info("place: " + elements.get(i).text());
            logger.info("name: " + elements.get(i + 1).text());
            events.addAll(parse(elements.get(i), elements.get(i + 1)));
        }
        return events;
    }

    public static final MusicResponse musicResponse(Elements elements) {
        return new MusicResponse(elements);
    }

    protected List<Event> parse(Element first, Element second) {
        List<Event> events = new ArrayList<Event>();

        EventBuilder builder = EventBuilder.create();
        builder.withEventPlace(first.text());
        builder.withEventCategory(Category.MUSIC);
        Elements rows = second.select("tr");
        String currentDate = "";
        for (int i = 2; i < rows.size(); i++) {
            String actualDate = rows.get(i).select("td").get(1).text().trim();
            if (!actualDate.equals("")) {
                actualDate = rowProvider.getRow(actualDate).split("\\(")[1];
                actualDate = replaceMonthIntDateString(actualDate);
            }
            if (currentDate.equals("") && !actualDate.equals("")) {
                currentDate = actualDate;
                builder.withStartDate(currentDate);
                builder.withEndDate(currentDate);
                builder.withEventName(rows.get(i).select("td").get(5).select(".txt").text());
                events.add(event(builder));
            } else if (currentDate.equals(actualDate) &&  !actualDate.equals("")) {
                currentDate = actualDate;
                builder.withStartDate(currentDate);
                builder.withEndDate(currentDate);
                builder.withEventName(rows.get(i).select("td").get(5).select(".txt").text());
                events.add(event(builder));
            } else if (!currentDate.equals("") && !actualDate.equals("")) {
                currentDate = actualDate;
                builder.withStartDate(currentDate);
                builder.withEndDate(currentDate);
                builder.withEventName(rows.get(i).select("td").get(5).select(".txt").text());
                events.add(event(builder));
            } else if (!currentDate.equals("")) {
                builder.withStartDate(currentDate);
                builder.withEndDate(currentDate);
                builder.withEventName(rows.get(i).select("td").get(5).select(".txt").text());
                events.add(event(builder));
            }
        }
        return events;
    }
}
