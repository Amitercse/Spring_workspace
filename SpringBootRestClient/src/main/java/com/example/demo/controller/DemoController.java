package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.DemoMessage;
import com.example.demo.model.ResponseMessage;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping
	public String getDemo() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("request-id", "12345");
        DemoMessage demoMessage= new DemoMessage();
        demoMessage.setId(123);
        demoMessage.setMessage("dummy message created");
        HttpEntity<DemoMessage> entity = new HttpEntity<>(demoMessage, headers);
        URI uri= new URI("http://localhost:8080/SpringAndRest/messages/dummy");
        ResponseEntity<ResponseMessage> result = restTemplate.postForEntity(uri, entity, ResponseMessage.class);
		System.out.println("message code: "+ result.getBody().getMessageCode());
		System.out.println("message value: "+ result.getBody().getMessage());
        return "hello world";
	}
}
