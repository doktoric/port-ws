package com.acme.doktoric.tags;

import java.util.List;

import com.acme.doktoric.types.base.Event;

public interface PortResponse {

	public static String[] MONTHS = new String[] { "január", "február",
			"március", "április", "május", "június", "július", "augusztus",
			"szeptember", "október", "november", "december" };
	public static String[] MONTHS_AS_NUMBER = new String[] { "01", "02", "03",
			"04", "05", "06", "07", "08", "09", "10", "11", "12" };

	public List<Event> process();

}
