package org.loginAuth.controller;

import org.loginAuth.dto.OrganizerDto;
import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.service.ServiceInterface;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizerRegistration")
public class OrganizerController {

	private ServiceInterface userService;

	public OrganizerController(ServiceInterface userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public OrganizerDto userRegistrationDto() {
        return new OrganizerDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "organizerRegistration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") OrganizerDto organizerDto) {
		userService.save(organizerDto);
		return "redirect:/organizerRegistration?registered";
	}
}
