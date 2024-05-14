package org.loginAuth.controller;

import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.repository.RatingRepository;
import org.loginAuth.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating/params{dead_params}{review}{reviewer}{reviewee}")
public class RatingController {

	private ServiceInterface userService;
	
	@Autowired
	private RatingRepository ratingRepositiory;

	public RatingController(ServiceInterface userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping
	public String setReviewController(@PathVariable String dead_params,String review,String reviewer,String reviewee) {
		ratingRepositiory.setReview(review,reviewer,reviewee);
		return "ratingPage";
		
	}
	
	
}
