package com.newmusic.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MusicResult {
	
	private String query;
	
	public MusicResult() {}
	
	public MusicResult(String q) {
		query = q;
	}

	public String getQuery() {
		return query;
	}
}
