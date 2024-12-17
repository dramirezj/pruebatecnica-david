package com.darj.demo.controller.users.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.darj.demo.controller.users.dto.UserDto;

@RestController
@RequestMapping("/github")
public class GitHubUserController {
	
	private final RestTemplate restTemplate;
	
	@Value("${github.url}")
	private String url;
	
	@Autowired
	public GitHubUserController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> all(@RequestParam String q) {
		this.url = url.concat(q);
		var content = restTemplate.getForObject(url, Object.class);
		//for(LinkedHashMap<K, V>)
		return new ResponseEntity<>(content, HttpStatus.OK);
	}
	
}
