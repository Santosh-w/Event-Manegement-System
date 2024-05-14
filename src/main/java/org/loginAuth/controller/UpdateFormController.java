package org.loginAuth.controller;

import org.loginAuth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/showUpdateForm")
public class UpdateFormController {

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping
	public String displayPage() {
		return "update";
	}
}





