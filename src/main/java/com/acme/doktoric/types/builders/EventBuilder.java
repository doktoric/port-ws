package com.acme.doktoric.types.builders;

import com.acme.doktoric.types.concrete.*;
import com.acme.doktoric.types.enums.Category;
import com.github.stokito.gag.annotation.enforceable.ThisHadBetterNotBe;
import com.github.stokito.gag.enumeration.Property;
import com.google.common.base.Optional;

import static com.acme.doktoric.types.concrete.EventDescription.eventDescription;
import static com.acme.doktoric.types.concrete.EventName.eventName;
import static com.acme.doktoric.types.concrete.EventPlace.eventPlace;
import static com.acme.doktoric.types.concrete.EventUrl.eventUrl;
import static com.acme.doktoric.types.concrete.EventStartDate.eventStartDate;
import static com.acme.doktoric.types.concrete.EventEndDate.eventEndDate;

public class EventBuilder {

    public EventEndDate toDate;
    public EventStartDate fromDate;
    public EventName name;
    public EventPlace place;
    public Optional<EventUrl> url = Optional.absent();
    public Optional<EventDescription> description = Optional.absent();
    public Category eventCategory;

    public static EventBuilder create() {
        return new EventBuilder();
    }

    public EventBuilder withEndDate(@ThisHadBetterNotBe(value = Property.NULL) EventEndDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public EventBuilder withEndDate(@ThisHadBetterNotBe(value = Property.NULL) String toDate) {
        this.toDate = eventEndDate(toDate);
        return this;
    }

    public EventBuilder withStartDate(@ThisHadBetterNotBe(value = Property.NULL) EventStartDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public EventBuilder  withStartDate(@ThisHadBetterNotBe(value = Property.NULL) String fromDate) {
        this.fromDate = eventStartDate(fromDate);
        return this;
    }

    public EventBuilder withEventName(@ThisHadBetterNotBe(value = Property.NULL) EventName eventName) {
        this.name = eventName;
        return this;
    }

    public EventBuilder withEventName(@ThisHadBetterNotBe(value = Property.NULL) String eventName) {
        this.name = eventName(eventName);
        return this;
    }

    public EventBuilder withEventPlace(@ThisHadBetterNotBe(value = Property.NULL) EventPlace eventPlace) {
        this.place = eventPlace;
        return this;
    }

    public EventBuilder withEventPlace(@ThisHadBetterNotBe(value = Property.NULL) String eventPlace) {
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

    public EventBuilder withEventCategory(@ThisHadBetterNotBe(value = Property.NULL) Category eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

}
