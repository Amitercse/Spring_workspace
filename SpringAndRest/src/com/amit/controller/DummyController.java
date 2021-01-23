package com.amit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amit.model.MessageResource;
import com.amit.util.Util;

/**
 * Controller class to map REST URL using @Controller annotation
 * @author Amit sharma
 *
 */
@RequestMapping("dummy")
@Controller
public class DummyController {

	@GetMapping
	public @ResponseBody List<MessageResource> getMessages()
	{
		return Util.getMessagesList();
	}
}
