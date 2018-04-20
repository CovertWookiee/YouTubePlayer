package com.covertwookiee.home.YouTubePlayer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.services.youtube.model.SearchResult;

@Component
public class YouTubeContactImpl implements YouTubeContact {

	@Autowired
	private Search search;
	
	public List<SearchResult> lookup(String input) {
		return search.search(input);
	}
}
