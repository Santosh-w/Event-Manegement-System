package org.loginAuth.repository;

import java.util.List;
import java.util.Optional;

import org.loginAuth.model.BookedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookedEventRepository extends JpaRepository<BookedEvent, Long>{
	Optional<BookedEvent> findByEventName(String eventName);

	@Transactional
	@Modifying 
	@Query(value = "insert into booked_event (organizer_name,event_name,client_name,booked_date) VALUES (?1, ?2,?3,now())", nativeQuery = true)
	void setUserInfoById(String organizer_name, String event_name,String client_name);
	
	
	@Query(value = "select * from booked_event where organizer_name=?1", nativeQuery = true)
    List<BookedEvent> findOrganizerBasedEvents(String organizer_name);
	
	@Transactional
	@Modifying
    @Query(value = "delete from booked_event  where organizer_name = ?1", nativeQuery = true)
    void deleteUsersByFirstName(String organizer_name);
}
