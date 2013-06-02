package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.DateType;
import org.joda.time.DateTime;

import java.text.ParseException;

public class EventEndDate extends DateType {

    public EventEndDate(String date) throws ParseException {
        this.date = simpleDateFormat.parseDateTime(date);
    }

    public EventEndDate(DateTime date) {
        this.date = date;
    }

    public static final EventEndDate eventEndDate(String date) {
        EventEndDate toDate = null;
        try {
            toDate = new EventEndDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toDate;
    }

    public static final EventEndDate eventEndDate(DateTime date) {
        return new EventEndDate(date);
    }
}
