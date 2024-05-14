package org.loginAuth.controller;

import org.loginAuth.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eventDetails{dead_param}{eventName}")
public class EventDetailsController {
	@Autowired
	private EventRepository eventRepository;
	
	
	@GetMapping
	public String showEventsForm() {
		return "eventDetails";
	}
	

	

}
