package com.acme.doktoric.response;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractResponse  implements Response {

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
	
	protected boolean isParsable(String element){
		boolean parsable=true;
		if(element.trim().equals("H K Sze Cs P Szo V")){
			parsable=false;
		}
		if(element.trim().equals("")){
			parsable=false;
		}
		return parsable;
	}

}
