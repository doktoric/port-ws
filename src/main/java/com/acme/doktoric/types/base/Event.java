package com.acme.doktoric.types.base;

import com.acme.doktoric.types.concrete.EventDescription;
import com.acme.doktoric.types.concrete.EventName;
import com.acme.doktoric.types.concrete.EventPlace;
import com.acme.doktoric.types.concrete.EventUrl;
import com.acme.doktoric.types.concrete.FromDate;
import com.acme.doktoric.types.concrete.ToDate;
import com.acme.doktoric.types.enums.Category;

public class Event {
	protected ToDate toDate;
	protected FromDate fromDate;
	protected EventName name;
	protected EventPlace place;
	protected EventUrl url;
	protected EventDescription description;
	protected Category eventCategory;

	public Category getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(Category eventCategory) {
		this.eventCategory = eventCategory;
	}

	

	public ToDate getToDate() {
		return toDate;
	}

	public void setToDate(ToDate toDate) {
		this.toDate = toDate;
	}

	public FromDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(FromDate fromDate) {
		this.fromDate = fromDate;
	}

	public EventName getName() {
		return name;
	}

	public void setName(EventName name) {
		this.name = name;
	}

	public EventPlace getPlace() {
		return place;
	}

	public void setPlace(EventPlace place) {
		this.place = place;
	}

	public EventUrl getUrl() {
		return url;
	}

	public void setUrl(EventUrl url) {
		this.url = url;
	}

	public EventDescription getDescription() {
		return description;
	}

	public void setDescription(EventDescription description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [toDate=" + toDate + ", fromDate=" + fromDate + ", name="
				+ name + ", place=" + place + ", url=" + url + ", description="
				+ description + ", eventCategory=" + eventCategory + "]";
	}

	
	
}

