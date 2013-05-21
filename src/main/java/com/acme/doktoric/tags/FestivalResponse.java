package com.acme.doktoric.tags;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.select.Elements;

import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;

public class FestivalResponse implements PortResponse {

	private Elements elements;
	private List<Event> events;
	public static String[] MONTHS = new String[] { "január", "február",
			"március", "április", "május", "június", "július", "augusztus",
			"szeptember", "október", "november", "december" };
	public static String[] MONTHS_AS_NUMBER = new String[] { "01", "02", "03",
			"04", "05", "06", "07", "08", "09", "10", "11", "12" };

	private FestivalResponse(Elements elements) {
		this.elements = elements;
		process();
	}

	public static final FestivalResponse festivalResponse(Elements elements) {
		return new FestivalResponse(elements);
	}

	public Elements getElements() {
		return elements;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void process() {
		events = new ArrayList<Event>();
		for (int i = 0; i < elements.size(); i++) {
			String element = elements.get(i).text();
			Event event = parse(element);
			events.add(event);
		}

	}

	private Event parse(String event) {
		Event returnEvent = null;
		try {
			String parts[] = event.split("-");
			String name = parts[0].trim();
			String place = parts[1].trim().split(" ")[0].trim();
			String fromDate = parts[1].trim().replace(place, "").trim();
			String toDate = parts[2].trim();
			fromDate = replaceMonthIntDateString(fromDate);
			toDate = replaceMonthIntDateString(toDate);

			returnEvent = EventBuilder.create()
					.withEventCategory(Category.FESTIVAL).withEventName(name)
					.withEventPlace(place).withFromDate(fromDate)
					.withToDate(toDate).build();
		} catch (Exception ex) {
			System.out.println("BAD__: " + event);
		}
		return returnEvent;
	}

	public static String replaceMonthIntDateString(String date) {
		date = date.replace(".", "").replace(" ", "-").trim();
		try {
			for (int i = 0; i < MONTHS.length; i++) {
				if (date.startsWith(MONTHS[i])) {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					date = year + "-" + date;
				}
				date = date.replace(MONTHS[i], MONTHS_AS_NUMBER[i]);
			}
		} catch (Exception ex) {
			System.out.println(date);
		}
		return date;
	}

}
