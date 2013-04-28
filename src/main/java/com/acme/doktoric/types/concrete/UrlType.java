package com.acme.doktoric.types.concrete;

import com.acme.doktoric.types.base.StringType;

public class UrlType extends StringType {

	private UrlType(String url) {
		this.value = url;
	}

	private UrlType() {
		this.value = "";
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static final UrlType urlType(String url) {
		return new UrlType(url);
	}
}



