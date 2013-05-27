package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.StringType;

public class EventUrl extends StringType {

    private EventUrl(String eventUrl) {
        this.value = eventUrl;
    }

    private EventUrl() {
        this.value = "";
    }

    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return value;
    }

    public static EventUrl eventUrl(String eventUrl) {
        return new EventUrl(eventUrl);
    }

    public static EventUrl eventUrl() {
        return new EventUrl();
    }

}
