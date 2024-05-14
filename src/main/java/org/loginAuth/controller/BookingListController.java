package org.loginAuth.controller;

import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.repository.BookedEventRepository;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookingListController {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BookedEventRepository bookedEventRepository;
	
	
	@GetMapping("organizerNotification/params{dummy}{organizer_name}")
	public ModelAndView displayEvents(@PathVariable String dummy,String organizer_name) {
		ModelAndView mav = new ModelAndView("organizerNotification");
		mav.addObject("bookings", bookedEventRepository.findOrganizerBasedEvents(organizer_name));
		return mav;
	}
	
	

}
