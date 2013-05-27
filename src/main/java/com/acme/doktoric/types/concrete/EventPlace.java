package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.StringType;

public class EventPlace extends StringType {

    private EventPlace(String eventPlace) {
        this.value = eventPlace;
    }

    private EventPlace() {
        this.value = "";
    }

    @Override
    public String getValue() {
        // TODO Auto-generated method stub
        return value;
    }

    public static EventPlace eventPlace(String eventPlace) {
        return new EventPlace(eventPlace);
    }

    public static EventPlace eventPlace() {
        return new EventPlace();
    }

}
