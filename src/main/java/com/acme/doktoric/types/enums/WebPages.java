package com.acme.doktoric.types.enums;

import static com.acme.doktoric.types.concrete.UrlType.urlType;

import com.acme.doktoric.types.concrete.UrlType;

public enum WebPages {
	PORT("http://port.hu/pls/");
	
	
	private UrlType url;
	
	private WebPages(String url) {
		this.url =urlType(url);
	}
	
	public String getUrl() {
		return url.getValue();
	}

}
