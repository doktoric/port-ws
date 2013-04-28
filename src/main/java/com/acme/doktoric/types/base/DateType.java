package com.acme.doktoric.types.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateType {

	protected Date date=new Date();
	protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd"); 

	protected Date getDate() {
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String dateAsString = getDateAsString(simpleDateFormat);
		return dateAsString;
	}

	protected String getDateAsString(SimpleDateFormat simpleDateFormat) {
		String dateAsString = simpleDateFormat.format(date);
		return dateAsString;
	}

	@Override
	public String toString() {
		return "DateType [dateAsString=" + date + "]";
	}

}
