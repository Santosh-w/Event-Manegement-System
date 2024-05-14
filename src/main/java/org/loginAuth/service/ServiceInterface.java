package org.loginAuth.service;


import org.loginAuth.dto.EventDto;
import org.loginAuth.dto.OrganizerDto;
import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.model.Event;
import org.loginAuth.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ServiceInterface extends UserDetailsService{
	User save(RegistrationDto registrationDto);
	User save(OrganizerDto organizerDto);
	Event save(EventDto eventDto);
	Event findByEventName(String eventName);
	
	
	
	
}
