package com.acme.doktoric.types.base;

import com.acme.doktoric.types.builders.EventBuilder;
import com.acme.doktoric.types.concrete.EventDescription;
import com.acme.doktoric.types.concrete.EventName;
import com.acme.doktoric.types.concrete.EventPlace;
import com.acme.doktoric.types.concrete.EventUrl;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;
import com.google.common.base.Optional;

public class Event {
	private final ToDate toDate;
	private final FromDate fromDate;
	private final EventName name;
	private final EventPlace place;
	private final Optional<EventUrl> url;
	private final Optional<EventDescription> description;
	private final Category eventCategory;

	
	private Event(EventBuilder builder){
		this.toDate=builder.toDate;
		this.fromDate=builder.fromDate;
		this.name=builder.name;
		this.place=builder.place;
		this.url=builder.url;
		this.description=builder.description;
		this.eventCategory=builder.eventCategory;
	}
	
	public Category getEventCategory() {
		return eventCategory;
	}

	public ToDate getToDate() {
		return toDate;
	}

	public FromDate getFromDate() {
		return fromDate;
	}

	public EventName getName() {
		return name;
	}

	public EventPlace getPlace() {
		return place;
	}

	public Optional<EventUrl> getUrl() {
		return url;
	}

	public Optional<EventDescription> getDescription() {
		return description;
	}

	@Override
	public String toString() {
		String toStringValue = "";
		toStringValue = name.getValue() 
						+ "| " + toDate.getDateAsString()
						+ "| " + fromDate.getDateAsString() 
						+ "| " + place.getValue() 
						+ "| " + ((url.isPresent()) ? url.get().getValue() : "empty")
						+ "| " + ((description.isPresent()) ? description.get().getValue() : "empty")		
						+ "| " + eventCategory + "";

		return toStringValue;
	}
	
	public static Event event(EventBuilder builder){
		return new Event(builder);
	}

}
