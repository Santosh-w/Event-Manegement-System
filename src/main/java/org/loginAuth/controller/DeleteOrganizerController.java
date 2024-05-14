package org.loginAuth.controller;

import org.loginAuth.repository.EventRepository;
import org.loginAuth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteUser/{userId}")
public class DeleteOrganizerController {

	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping
	public String deleteUsers(@PathVariable Long userId) {
		usersRepository.deleteById(userId);
		return "redirect:/organizerList";
	}
	}
	
	
	


