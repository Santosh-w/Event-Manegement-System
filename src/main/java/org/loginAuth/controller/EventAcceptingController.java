package org.loginAuth.controller;

import org.loginAuth.repository.AcceptedEventRepository;
import org.loginAuth.repository.BookedEventRepository;
import org.loginAuth.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acceptEvent/params{dead_param}{organizer_name}{event_name}{client_name}")
public class EventAcceptingController {
	
	private ServiceInterface userService;
	
	
	@Autowired
	private AcceptedEventRepository acceptedEventRepository;
	@Autowired
	private BookedEventRepository bookedEventRepository;
	
	
	
	@GetMapping
	public String acceptEvent(@PathVariable String dead_param,  String organizer_name, String event_name,String client_name) {
		
		acceptedEventRepository.setUserInfoById( organizer_name,event_name, client_name);
		bookedEventRepository.deleteUsersByFirstName(organizer_name);
		
		return "redirect:/organizerNotification/params?deadparam=dummuy&organizer_name=akshay@gmail.com";
	}

	
}
