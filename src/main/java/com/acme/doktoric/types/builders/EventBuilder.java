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

    public EventBuilder withToDate(@ThisHadBetterNotBe(value = Property.NULL) ToDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public EventBuilder withToDate(@ThisHadBetterNotBe(value = Property.NULL) String toDate) {
        this.toDate = toDate(toDate);
        return this;
    }

    public EventBuilder withFromDate(@ThisHadBetterNotBe(value = Property.NULL) FromDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public EventBuilder withFromDate(@ThisHadBetterNotBe(value = Property.NULL) String fromDate) {
        this.fromDate = fromDate(fromDate);
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
