package com.acme.doktoric.response;

import com.github.stokito.gag.annotation.enforceable.CantTouchThis;
import com.github.stokito.gag.annotation.enforceable.ThisHadBetterNotBe;
import com.github.stokito.gag.enumeration.Property;
import com.github.stokito.gag.enumeration.Stop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;


public abstract class AbstractResponse implements Response {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractResponse.class);

    protected String replaceMonthIntDateString(@ThisHadBetterNotBe(value = Property.NULL) String date) {
        date = date.replaceAll("[0-9][0-9]:[0-9][0-9]", "")
                .replace(".", "")
                .replace("Egész nap", "")
                .replace(" ", "-")
                .trim();
        try {
            for (int i = 0; i < MONTHS.length; i++) {
                if (date.startsWith(MONTHS[i])) {
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    date = year + "-" + date;
                }
                date = date.replace(MONTHS[i], MONTHS_AS_NUMBER[i]);
            }
            for (int i = 0; i < MONTHS_SHORT.length; i++) {
                if (date.startsWith(MONTHS_SHORT[i])) {
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    date = year + "-" + date;
                }
                date = date.replace(MONTHS_SHORT[i], MONTHS_AS_NUMBER[i]);
            }
            date = replaceLast(date, "-", "");
        } catch (Exception ex) {
            logger.info(date);
        }
        return date;
    }

    private String replaceLast(String string, String toReplace, String replacement) {
        int pos = string.lastIndexOf(toReplace);
        if (pos > -1 && pos == string.length() - 1) {
            return string.substring(0, pos)
                    + replacement
                    + string.substring(pos + toReplace.length(), string.length());
        } else {
            return string;
        }
    }

    protected boolean isParsable(String element) {
        boolean parsable = true;
        if (element.trim().equals("H K Sze Cs P Szo V")) {
            parsable = false;
        }
        if (element.trim().equals("")) {
            parsable = false;
        }
        return parsable;
    }

}
