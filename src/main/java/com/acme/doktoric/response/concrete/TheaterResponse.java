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
        for (int i = 1; i < elements.size() - 1; i = i + 2) {
            events.addAll(parse(elements.get(i), elements.get(i + 1)));
        }
        return events;
    }

    protected List<Event> parse(Element part1, Element part2) {
        List<Event> events = new ArrayList<Event>();
        EventBuilder builder = EventBuilder.create();
        builder.withEventCategory(Category.THEATER);
        builder.withEventName(part1.select(".e_title2,.e_title_box2").text());
        builder.withEventPlace(part2.select(".e_org_box2").text());
        Elements dates = part2.select(".e_date2").select("span");
        for (int i = 0; i < dates.size(); i++) {
            String date = rowProvider.getRow(dates.get(i).text());
            date = replaceMonthIntDateString(date);
            builder.withStartDate(date);
            builder.withEndDate(date);
            events.add(event(builder));
        }
        return events;
    }

    public static final TheaterResponse theaterResponse(Elements elements) {
        return new TheaterResponse(elements);
    }
}
