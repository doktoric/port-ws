package com.acme.doktoric.types.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class DateType {

	protected DateTime  date=new DateTime();
	protected DateTimeFormatter  simpleDateFormat = DateTimeFormat.forPattern("YYYY-MM-dd"); 

	public DateTime getDate() {
		return date;
	}

	protected String getDateAsString() {
		String dateAsString = date.toString();
		return dateAsString;
	}
	
	protected String getFormattedDateAsString() {
		String dateAsString = getDateAsString(simpleDateFormat);
		return dateAsString;
	}


	protected String getDateAsString(String dateFormat) {
		String dateAsString = getDateAsString(DateTimeFormat.forPattern(dateFormat));
		return dateAsString;
	}

	protected String getDateAsString(DateTimeFormatter simpleDateFormat) {
		String dateAsString = simpleDateFormat.print(date);
		return dateAsString;
	}

	@Override
	public String toString() {
		return "DateType [dateAsString=" + date + "]";
	}

}
