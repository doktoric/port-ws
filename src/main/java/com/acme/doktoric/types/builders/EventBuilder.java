package com.acme.doktoric.types.builders;
import static com.acme.doktoric.types.concrete.FromDate.*;
import static com.acme.doktoric.types.concrete.ToDate.*;
import static com.acme.doktoric.types.concrete.EventName.*;
import static com.acme.doktoric.types.concrete.EventPlace.*;
import static com.acme.doktoric.types.concrete.EventUrl.*;
import static com.acme.doktoric.types.concrete.EventDescription.*;

import com.acme.doktoric.types.base.Event;
import com.acme.doktoric.types.concrete.EventDescription;
import com.acme.doktoric.types.concrete.EventName;
import com.acme.doktoric.types.concrete.EventPlace;
import com.acme.doktoric.types.concrete.EventUrl;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.EventCategory;

public class EventBuilder {

	private static Event event;

	public static EventBuilder create() {
		return new EventBuilder();
	}

	public EventBuilder withToDate(ToDate toDate) {
		event.setToDate(toDate);
		return this;
	}

	public EventBuilder withToDate(String toDate) {
		event.setToDate(toDate(toDate));
		return this;
	}

	public EventBuilder withFromDate(FromDate fromDate) {
		event.setFromDate(fromDate);
		return this;
	}

	public EventBuilder withFromDate(String fromDate) {
		event.setFromDate(fromDate(fromDate));
		return this;
	}

	public EventBuilder withEventName(EventName eventName) {
		event.setName(eventName);
		return this;
	}

	public EventBuilder withEventName(String eventName) {
		event.setName(eventName(eventName));
		return this;
	}

	public EventBuilder withEventPlace(EventPlace eventPlace) {
		event.setPlace(eventPlace);
		return this;
	}

	public EventBuilder withEventPlace(String eventPlace) {
		event.setPlace(eventPlace(eventPlace));
		return this;
	}

	public EventBuilder withEventUrl(EventUrl eventUrl) {
		event.setUrl(eventUrl);
		return this;
	}

	public EventBuilder withEventUrl(String eventUrl) {
		event.setUrl(eventUrl(eventUrl));
		return this;
	}

	public EventBuilder withEventDescription(EventDescription eventDescription) {
		event.setDescription(eventDescription);
		return this;
	}

	public EventBuilder withEventDescription(String eventDescription) {
		event.setDescription(eventDescription(eventDescription));
		return this;
	}

	public EventBuilder withEventCategory(EventCategory eventCategory) {
		event.setEventCategory(eventCategory);
		return this;
	}

	public Event build() {
		return event;

	}
}
