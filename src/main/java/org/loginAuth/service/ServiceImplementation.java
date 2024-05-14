package org.loginAuth.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.loginAuth.dto.EventDto;
import org.loginAuth.dto.OrganizerDto;
import org.loginAuth.dto.RegistrationDto;
import org.loginAuth.model.Event;
import org.loginAuth.model.Organizer;
import org.loginAuth.model.Role;
import org.loginAuth.model.User;
import org.loginAuth.repository.BookedEventRepository;
import org.loginAuth.repository.EventRepository;
import org.loginAuth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ServiceImplementation implements ServiceInterface{

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private BookedEventRepository bookedEventRepository;


	private OrganizerDto organizerDto;
	private Organizer organizer;
	
	public ServiceImplementation(UsersRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(RegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}
	@Override
	public User save(OrganizerDto organizerDto) {
		User organizer = new User(organizerDto.getFirstName(), 
				organizerDto.getLastName(), organizerDto.getEmail(),
				passwordEncoder.encode(organizerDto.getPassword()), Arrays.asList(new Role("ROLE_ORGANIZER")));

		return userRepository.save(organizer);
	}
	
	@Override
	public Event save(EventDto eventDto) {
		Event event = new Event(eventDto.getEventName(),eventDto.getDescription(),eventDto.getStartDate(),eventDto.getEndDate(),eventDto.getPricing(),eventDto.getOrganizerName());

		return eventRepository.save(event);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public Event findByEventName(String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	

	
}
