package com.acme.doktoric.types.enums;
import static com.acme.doktoric.types.concrete.UrlType.*;
import com.acme.doktoric.types.concrete.UrlType;

public enum Category {
	FESTIVAL("fe/festival.festival_list?"),
	MOVIES("ci/cinema.list_days?"),
	THEATER("w/theatre.date_body?"),
	RESTAURANT("w/exhibition.create_events?"),
	CHILD("w/child.event_list?"),
	BOOK("w/event_topic.create_events?"),
	MUSIC("w/concert.list_days?");
	

	private UrlType categoryUrl;

	private Category(String categoryUrl) {
		this.categoryUrl =urlType(categoryUrl);
	}

	private Category(UrlType categoryUrl) {
		this.categoryUrl = categoryUrl;
	}

	public String getUrl() {
		return categoryUrl.getValue();
	}

	public UrlType getCategoryUrl() {
		return categoryUrl;
	}

}
