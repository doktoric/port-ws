package com.acme.doktoric.types.builders;

import com.acme.doktoric.types.concrete.*;
import com.acme.doktoric.types.enums.Category;
import com.google.common.base.Optional;

import static com.acme.doktoric.types.concrete.EventDescription.eventDescription;
import static com.acme.doktoric.types.concrete.EventName.eventName;
import static com.acme.doktoric.types.concrete.EventPlace.eventPlace;
import static com.acme.doktoric.types.concrete.EventUrl.eventUrl;
import static com.acme.doktoric.types.concrete.FromDate.fromDate;
import static com.acme.doktoric.types.concrete.ToDate.toDate;

public class EventBuilder {

    public ToDate toDate;
    public FromDate fromDate;
    public EventName name;
    public EventPlace place;
    public Optional<EventUrl> url = Optional.absent();
    public Optional<EventDescription> description = Optional.absent();
    public Category eventCategory;

    public static EventBuilder create() {
        return new EventBuilder();
    }

    public EventBuilder withToDate(ToDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public EventBuilder withToDate(String toDate) {
        this.toDate = toDate(toDate);
        return this;
    }

    public EventBuilder withFromDate(FromDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public EventBuilder withFromDate(String fromDate) {
        this.fromDate = fromDate(fromDate);
        return this;
    }

    public EventBuilder withEventName(EventName eventName) {
        this.name = eventName;
        return this;
    }

    public EventBuilder withEventName(String eventName) {
        this.name = eventName(eventName);
        return this;
    }

    public EventBuilder withEventPlace(EventPlace eventPlace) {
        this.place = eventPlace;
        return this;
    }

    public EventBuilder withEventPlace(String eventPlace) {
        this.place = eventPlace(eventPlace);
        return this;
    }

    public EventBuilder withEventUrl(EventUrl eventUrl) {
        this.url = Optional.of(eventUrl);
        return this;
    }

    public EventBuilder withEventUrl(String eventUrl) {
        this.url = Optional.of(eventUrl(eventUrl));
        return this;
    }

    public EventBuilder withEventDescription(EventDescription eventDescription) {
        this.description = Optional.of(eventDescription);
        return this;
    }

    public EventBuilder withEventDescription(String eventDescription) {
        this.description = Optional.of(eventDescription(eventDescription));
        return this;
    }

    public EventBuilder withEventCategory(Category eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

}
