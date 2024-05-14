package org.loginAuth.controller;

import org.loginAuth.repository.BookedEventRepository;
import org.loginAuth.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookEvent/params{dead_param}{organizer_name}{event_name}{client_name}")
public class EventBookingController {
	
	private ServiceInterface userService;
	
	
	@Autowired
	private BookedEventRepository bookedEventRepository;
	
	
	
	@GetMapping
	public String bookEvent(@PathVariable String dead_param,  String organizer_name, String event_name,String client_name) {
		
		bookedEventRepository.setUserInfoById( organizer_name,event_name, client_name);
		return "redirect:/eventList?registered";
	}

	
}
