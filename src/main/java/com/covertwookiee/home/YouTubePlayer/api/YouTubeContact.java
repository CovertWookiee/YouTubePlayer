package com.covertwookiee.home.YouTubePlayer.api;

import java.util.List;

import com.google.api.services.youtube.model.SearchResult;

public interface YouTubeContact {

	List<SearchResult> lookup(String anyString);
}
