package com.covertwookiee.home.YouTubePlayer.player;

import org.springframework.stereotype.Component;

import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

@Component
public class YouTubePlayerImpl implements YouTubePlayer {
	
	public void play(SearchResult searchResult) {
		prettyPrint(searchResult);
	}
	
	
	
	
	/*
     * Prints out all results in the Iterator. For each result, print the
     * title, video ID, and thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    private static void prettyPrint(SearchResult iteratorSearchResults) {

        SearchResult singleVideo = iteratorSearchResults;
        ResourceId rId = singleVideo.getId();

        // Confirm that the result represents a video. Otherwise, the
        // item will not contain a video ID.
        if (rId.getKind().equals("youtube#video")) {
            Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();

            System.out.println(" Video Id" + rId.getVideoId());
            System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
            System.out.println(" Thumbnail: " + thumbnail.getUrl());
            System.out.println("\n-------------------------------------------------------------\n");
        }
    }
}
