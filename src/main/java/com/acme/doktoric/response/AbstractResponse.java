package com.acme.doktoric.response;

import com.acme.doktoric.provider.RowProvider;
import com.acme.doktoric.provider.RowProviderImp;
import com.github.stokito.gag.annotation.remark.Magic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

import static com.acme.doktoric.provider.RowProviderImp.rowProvider;


public abstract class AbstractResponse implements Response {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractResponse.class);
    protected RowProvider rowProvider;

    public AbstractResponse() {
        rowProvider = rowProvider();
    }

    @Magic
    protected String replaceMonthIntDateString(String date) {
        date = date.replace(String.valueOf((char) 160), " ")
                .replaceAll("[0-9][0-9]:[0-9][0-9]", "")
                .replaceAll("[0-9]:[0-9][0-9]", "")
                .trim()
                .replace(".", "")
                .replace("(", "")
                .replace(")", "")
                .trim()
                .replace("Egész nap", "")
                .trim()
                .replace(" ", "-")
                .replace(" - ", "")
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
