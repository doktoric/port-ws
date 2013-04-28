package com.acme.doktoric.types.enums;
import static com.acme.doktoric.types.concrete.UrlType.*;
import com.acme.doktoric.types.concrete.UrlType;

public enum Category {
	FESTIVAL("fe/festival.festival_list?");

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
