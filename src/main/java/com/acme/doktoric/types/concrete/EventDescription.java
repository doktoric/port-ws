package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.StringType;

public class EventDescription extends StringType {

	private EventDescription(String eventDescription) {
		this.value = eventDescription;
	}

	private EventDescription() {
		this.value = "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventDescription eventDescription(String eventDescription) {
		return new EventDescription(eventDescription);
	}

	public static EventDescription eventDescription() {
		return new EventDescription();
	}

}
