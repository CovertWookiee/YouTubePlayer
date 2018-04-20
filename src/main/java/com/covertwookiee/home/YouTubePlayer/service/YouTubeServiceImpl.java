package com.covertwookiee.home.YouTubePlayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covertwookiee.home.YouTubePlayer.api.YouTubeContact;
import com.covertwookiee.home.YouTubePlayer.player.YouTubePlayer;
import com.google.api.services.youtube.model.SearchResult;

@Component
public class YouTubeServiceImpl implements YouTubeService {
	@Autowired
	YouTubeContact youtube;
	
	@Autowired
	YouTubePlayer player;
	
	public void getVideo(String input) {
		List<SearchResult> list = youtube.lookup(input);
		if(!list.isEmpty()) {
			player.play(list.get(0));
		} else {
			return;
		}
	}
}