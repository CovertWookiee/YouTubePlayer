package com.covertwookiee.home.YouTubePlayer;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.covertwookiee.home.YouTubePlayer.api.YouTubeContact;
import com.covertwookiee.home.YouTubePlayer.player.YouTubePlayer;
import com.covertwookiee.home.YouTubePlayer.service.YouTubeService;
import com.covertwookiee.home.YouTubePlayer.service.YouTubeServiceImpl;
import com.google.api.services.youtube.model.SearchResult;

public class ServiceTest {
	@Mock
	private YouTubeContact ytc;
	@Mock
	private YouTubePlayer ytp;
	
	YouTubeService service;
	
	@Before
	public void setup() {
		service = new YouTubeServiceImpl();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "youtube", ytc);
		ReflectionTestUtils.setField(service, "player", ytp);
	}
	
	@Test
	public void testServiceCallsYouTubeApi() {
		service.getVideo("memes");
		Mockito.verify(ytc).lookup(Mockito.anyString());
	}
	
	@Test
	public void testServiceCallsYouTubeApiWithCorrectParams() {
		service.getVideo("mega-memes");
		Mockito.verify(ytc).lookup(Mockito.eq("mega-memes"));
	}
	
	@Test
	public void testServiceChainsIntoPlayWhenNotEmptyList() {
		List<SearchResult> mockList = Mockito.mock(List.class);
		Mockito.when(ytc.lookup(Mockito.anyString())).thenReturn(mockList);
		SearchResult result = new SearchResult();
		Mockito.when(mockList.isEmpty()).thenReturn(false);
		Mockito.when(mockList.get(0)).thenReturn(result);
		service.getVideo("ultra-memes");
		Mockito.verify(ytp).play(Mockito.any(SearchResult.class));
	}
	
	@Test
	public void testServiceDoesNotChainWhenEmptyList() {
		List<SearchResult> mockList = Mockito.mock(List.class);
		Mockito.when(ytc.lookup(Mockito.anyString())).thenReturn(mockList);
		SearchResult result = new SearchResult();
		Mockito.when(mockList.isEmpty()).thenReturn(true);
		Mockito.when(mockList.get(0)).thenReturn(result);
		service.getVideo("ultra-memes");
		Mockito.verifyZeroInteractions(ytp);
	}
}
