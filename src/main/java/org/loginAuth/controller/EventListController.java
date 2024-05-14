package org.loginAuth.controller;

import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.repository.EventRepository;
import org.loginAuth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/eventList")
public class EventListController {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	
	
	@GetMapping
	public ModelAndView displayEvents() {
		ModelAndView mav = new ModelAndView("eventList");
		mav.addObject("events", eventRepository.findAll());
		return mav;
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUsers(@PathVariable Long userId) {
		usersRepository.deleteById(userId);
		return "redirect:/organizerList";
	}

}
