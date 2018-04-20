package com.covertwookiee.home.YouTubePlayer.player;

import com.google.api.services.youtube.model.SearchResult;

public interface YouTubePlayer {

	void play(SearchResult searchResult);

}
