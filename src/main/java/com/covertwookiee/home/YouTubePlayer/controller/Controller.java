package com.covertwookiee.home.YouTubePlayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.covertwookiee.home.YouTubePlayer.service.YouTubeService;

@RestController
public class Controller {
	
	@Autowired
	private YouTubeService service;
	
	@GetMapping("/playVideo/{keyword}")
	public void playVideo(@PathVariable("keyword") String keyword) {
		System.out.println("Searching for: " + keyword);
		service.getVideo(keyword);
	}
}
