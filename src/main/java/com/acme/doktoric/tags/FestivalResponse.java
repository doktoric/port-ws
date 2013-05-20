package com.acme.doktoric.tags;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.enums.Category;

public class FestivalResponse implements PortResponse {

	private Elements elements;

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

	public void process() {
		List<Event> events=new ArrayList<Event>();
		for (int i = 0; i < elements.size(); i++) {
			String element=elements.get(i).text();
			Event event=parse(element);
			events.add(event);
		}

	}
	
	private Event parse(String event){
		String parts[]=event.split("-");
		String name=parts[0].trim();
		String place=parts[1].trim().split(" ")[0].trim();
		String fromDate=parts[1].trim().replace(place, "").trim();
		String toDate=parts[2].trim();
		
		Event returnEvent=EventBuilder.create()
				.withEventCategory(Category.FESTIVAL)
				.withEventName(name)
				.withEventPlace(place)
				.withFromDate(fromDate)
				.withToDate(toDate)
				.build();
		
		return returnEvent;
	}

}
