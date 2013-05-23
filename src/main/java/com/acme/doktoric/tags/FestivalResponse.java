package com.acme.doktoric.tags;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;

public class FestivalResponse implements PortResponse {

	private static final Logger logger = LoggerFactory.getLogger(PortResponse.class);

	private Elements elements;
	private List<Event> events;


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
			if (!element.trim().equals("H K Sze Cs P Szo V")) {
				Event event = parse(element);
				events.add(event);
			}
			
		}

	}

	private Event parse(String event) {
		Event returnEvent = null;
		try {
			returnEvent = specialEventParser(event).build();
		} catch (Exception ex) {
			logger.info("dsfsdfsdf");
		}

		return returnEvent;
	}

	private EventBuilder specialEventParser(String event) {
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

			return EventBuilder.create().withEventCategory(Category.FESTIVAL)
					.withEventName(name).withEventPlace(place)
					.withFromDate(fromDate).withToDate(toDate);
		} catch (Exception ex) {
			logger.info("BAD__: " + event);
			return null;
		}

	}

	private EventBuilder simpleEventParser(String event) throws Exception {
		String parts[] = event.split("-");
		String name = parts[0].trim();
		String place = parts[1].trim().split(" ")[0].trim();
		String fromDate = parts[1].trim().replace(place, "").trim();
		String toDate = parts[2].trim();
		fromDate = replaceMonthIntDateString(fromDate);
		toDate = replaceMonthIntDateString(toDate);

		return EventBuilder.create().withEventCategory(Category.FESTIVAL)
				.withEventName(name).withEventPlace(place)
				.withFromDate(fromDate).withToDate(toDate);
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
			logger.info(date);
		}
		return date;
	}

}
