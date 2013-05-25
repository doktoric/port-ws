package com.acme.doktoric.tags;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractResponse  implements PortResponse {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractResponse.class);
	
	protected String replaceMonthIntDateString(String date) {
		date = date.replace(".", "").replace(" ", "-").trim();
		try {
			for (int i = 0; i < MONTHS.length; i++) {
				if (date.startsWith(MONTHS[i])) {
					int year = Calendar.getInstance().get(Calendar.YEAR);
					date = year + "-" + date;
				}
				date = date.replace(MONTHS[i], MONTHS_AS_NUMBER[i]);
			}
		} catch (Exception ex) {
			logger.info(date);
		}
		return date;
	}

}
