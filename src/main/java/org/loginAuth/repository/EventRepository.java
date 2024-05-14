package org.loginAuth.repository;

import java.util.Optional;

import org.loginAuth.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	Optional<Event> findByEventName(String eventName);
	
	
}
