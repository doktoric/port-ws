package com.acme.doktoric.tags;

import org.jsoup.select.Elements;

public class FestivalResponse implements PortResponse {

	private Elements elements;
	
	private FestivalResponse(Elements elements) {
		this.elements=elements;
		process();
	}

	public static final FestivalResponse festivalResponse(Elements elements) {
		return new FestivalResponse(elements);
	}
	
	

	public Elements getElements() {
		return elements;
	}

	public void process() {
		// TODO Auto-generated method stub

	}

}
