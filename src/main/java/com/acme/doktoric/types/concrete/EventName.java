package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.StringType;

public class EventName extends StringType {

	private EventName(String eventName) {
		this.value = eventName;
	}

	private EventName() {
		this.value = "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public static EventName eventName(String eventName) {
		return new EventName(eventName);
	}

	public static EventName eventName() {
		return new EventName();
	}

}
