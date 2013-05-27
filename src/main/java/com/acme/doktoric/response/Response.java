package com.acme.doktoric.response;

import com.acme.doktoric.types.base.Event;

import java.util.List;

public interface Response {

    public static String[] MONTHS = new String[]{"január", "február",
            "március", "április", "május", "június", "július", "augusztus",
            "szeptember", "október", "november", "december"};
    public static String[] MONTHS_SHORT = new String[]{"jan", "febr",
            "márc", "ápr", "máj", "jún", "júl", "aug",
            "szept", "okt", "nov", "dec"};
    public static String[] MONTHS_AS_NUMBER = new String[]{"01", "02", "03",
            "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    public List<Event> process();

}
