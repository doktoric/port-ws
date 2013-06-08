package com.acme.doktoric.response;

import com.acme.doktoric.types.base.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Response {

    public static String[] MONTHS = new String[]{"január", "február",
            "március", "április", "május", "június", "július", "augusztus",
            "szeptember", "október", "november", "december"};
    public static List<String> BIG_CAPITAL_MONTHS = new ArrayList<String>(Arrays.asList("Január", "Február",
            "Március", "Április", "Május", "Június", "Július", "Augusztus",
            "Szeptember", "Október", "November", "December"));
    public static String[] MONTHS_SHORT = new String[]{"jan", "febr",
            "márc", "ápr", "máj", "jún", "júl", "aug",
            "szept", "okt", "nov", "dec"};
    public static String[] MONTHS_AS_NUMBER = new String[]{"01", "02", "03",
            "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    public static String DAYS = new String("Hétfő|Kedd|Szerda|Csütörtök|Péntek|Szombat|Vasárnap");


    public List<Event> process();

}
