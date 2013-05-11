package com.acme.doktoric.types.concrete;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;

import com.acme.doktoric.types.base.DateType;

public class FromDate extends DateType {
	
	public FromDate(String date) throws ParseException {
		this.date =  simpleDateFormat.parseDateTime(date);
	}

	public FromDate(DateTime date) {
		this.date = date;
	}

	public static final FromDate fromDate(String date) {
		FromDate fromDate = null;
		try {
			fromDate = new FromDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fromDate;
	}

	public static final FromDate fromDate(DateTime date) {
		return new FromDate(date);
	}
}
