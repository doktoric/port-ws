package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.DateType;
import org.joda.time.DateTime;

import java.text.ParseException;

public class FromDate extends DateType {


    private FromDate(String date) throws ParseException {
        this.date = simpleDateFormat.parseDateTime(date);
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
