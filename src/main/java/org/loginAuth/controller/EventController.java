package org.loginAuth.controller;

import java.util.ArrayList;
import java.util.List;

import org.loginAuth.dto.EventDto;
import org.loginAuth.model.Event;
import org.loginAuth.repository.EventRepository;
import org.loginAuth.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/events")
public class EventController {

	private ServiceInterface userService;
	
	@Autowired
	private EventRepository eventRepository; 

	public EventController(ServiceInterface userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("event")
    public EventDto eventRegistrationDto() {
        return new EventDto();
    }
	
	@GetMapping
	public String showEventsForm() {
		return "events";
	}
	
	@PostMapping
	public String registerEvent(@ModelAttribute("event") EventDto eventDto) {
		userService.save(eventDto);
		return "redirect:/events?registered";
	}
	
	@ResponseBody
	@GetMapping("/eventList")
	public List<Event> displayEvents() {
	    List<Event> list = new ArrayList<>();
	    eventRepository.findAll().forEach(list::add);
	    return list;
	}
	
}
