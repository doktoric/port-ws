package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.DateType;
import org.joda.time.DateTime;

import java.text.ParseException;

public class ToDate extends DateType {

    public ToDate(String date) throws ParseException {
        this.date = simpleDateFormat.parseDateTime(date);
    }

    public ToDate(DateTime date) {
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

    public static final ToDate toDate(DateTime date) {
        return new ToDate(date);
    }
}
