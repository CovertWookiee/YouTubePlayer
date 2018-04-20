package com.covertwookiee.home.YouTubePlayer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.covertwookiee.home.YouTubePlayer.api.Search;
import com.covertwookiee.home.YouTubePlayer.api.YouTubeContact;
import com.covertwookiee.home.YouTubePlayer.api.YouTubeContactImpl;

public class ApiTest {
	
	@Mock
	Search search;

	private YouTubeContact yt;
	
	@Before
	public void setup() {
		yt = new YouTubeContactImpl();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(yt, "search", search);
	}
	
	@Test
	public void testContactCallsSearch() {
		yt.lookup("memes");
		Mockito.verify(search).search(Mockito.anyString());
	}
	
	@Test
	public void testContactCallsSearchWithCorrectArg() {
		yt.lookup("mega-memes");
		Mockito.verify(search).search(Mockito.eq("mega-memes"));
	}
}
