package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.Event;

import java.util.List;

public class EventResponse {

    protected List<? extends Event> events;

    public List<? extends Event> getEvents() {
        return events;
    }

    public void setEvents(List<? extends Event> events) {
        this.events = events;
    }

}
