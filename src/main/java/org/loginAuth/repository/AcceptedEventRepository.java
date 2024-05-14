package org.loginAuth.repository;

import java.util.Optional;

import org.loginAuth.model.AcceptedEvent;
import org.loginAuth.model.BookedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AcceptedEventRepository extends JpaRepository<AcceptedEvent, Long>{
	Optional<BookedEvent> findByEventName(String eventName);

	@Transactional
	@Modifying 
	@Query(value = "insert into accepted_event (organizer_name,event_name,client_name,accepted_date) VALUES (?1, ?2,?3,now())", nativeQuery = true)
	void setUserInfoById(String organizer_name, String event_name,String client_name);
	
	
	
	
	
}
