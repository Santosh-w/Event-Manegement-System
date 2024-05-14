package org.loginAuth.controller;

import org.loginAuth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/updateUser{userId}{first_name}{last_name}")
public class UpdateOrganizerController {

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping
	public String updateUsers(@RequestParam String firstName, String lastName, Long userId) {
		usersRepository.setUserInfoById(firstName, lastName,userId);
		return "redirect:/organizerList";
	}
	@GetMapping("/showUpdateForm")
	public String displayPage() {
		return "update";
	}
}





