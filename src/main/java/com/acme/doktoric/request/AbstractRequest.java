package com.acme.doktoric.request;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractRequest implements Request {

	protected DateTime StartDayOfMonth() {
		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat
				.forPattern("YYYY-MM-dd");
		actual = viewDateFormat.parseDateTime("2013-04-01");
		return actual;
	}

	protected DateTime EndDayOfMonth() {
		DateTime actual = null;
		DateTimeFormatter viewDateFormat = DateTimeFormat
				.forPattern("YYYY-MM-dd");
		actual = viewDateFormat.parseDateTime("2013-04-30");
		return actual;
	}

}
