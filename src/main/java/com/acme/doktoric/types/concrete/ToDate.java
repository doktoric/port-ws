package com.acme.doktoric.types.concrete;

import java.text.ParseException;
import java.util.Date;

import com.acme.doktoric.types.base.DateType;

public class ToDate extends DateType {

	public ToDate(String date) throws ParseException {
		this.date = simpleDateFormat.parse(date);
	}

	public ToDate(Date date) {
		this.date = date;
	}

	public static final ToDate toDate(String date) {
		ToDate toDate = null;
		try {
			toDate = new ToDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return toDate;
	}

	public static final ToDate toDate(Date date) {
		return new ToDate(date);
	}
}
