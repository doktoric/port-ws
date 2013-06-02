package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.DateType;
import org.joda.time.DateTime;

import java.text.ParseException;

public class EventStartDate extends DateType {


    private EventStartDate(String date) throws ParseException {
        this.date = simpleDateFormat.parseDateTime(date);
    }

    public EventStartDate(DateTime date) {
        this.date = date;
    }

    public static final EventStartDate fromDate(String date) {
        EventStartDate fromDate = null;
        try {
            fromDate = new EventStartDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fromDate;
    }

    public static final EventStartDate fromDate(DateTime date) {
        return new EventStartDate(date);
    }
}
