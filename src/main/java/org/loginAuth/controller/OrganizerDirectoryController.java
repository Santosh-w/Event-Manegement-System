package org.loginAuth.controller;

import java.util.List;

import org.loginAuth.model.User;
import org.loginAuth.repository.EventRepository;
import org.loginAuth.repository.UsersRepository;
import org.loginAuth.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/organizerContact")
public class OrganizerDirectoryController {
	
	private ServiceInterface userService;
	@Autowired
	private UsersRepository usersRepository;
	
	
	
	@GetMapping
	public ModelAndView displayEvents() {
		ModelAndView mav = new ModelAndView("organizerContact");
		mav.addObject("users", usersRepository.findUsersByRole());
		mav.addObject("all",usersRepository.findAll());
		return mav;
	}
	
	
	

}
