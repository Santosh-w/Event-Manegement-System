package org.loginAuth.controller;

import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.service.ServiceInterface;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private ServiceInterface userService;

	public RegistrationController(ServiceInterface userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public RegistrationDto userRegistrationDto() {
        return new RegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") RegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?registered";
	}
}
