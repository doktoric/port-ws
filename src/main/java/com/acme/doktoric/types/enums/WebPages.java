package com.acme.doktoric.types.enums;

import com.acme.doktoric.types.concrete.UrlType;

import static com.acme.doktoric.types.concrete.UrlType.urlType;

public enum WebPages {
    PORT("http://port.hu/pls/");


    private UrlType url;

    private WebPages(String url) {
        this.url = urlType(url);
    }

    public String getUrl() {
        return url.getValue();
    }

}
