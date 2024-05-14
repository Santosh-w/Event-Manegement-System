package org.loginAuth.repository;

import org.loginAuth.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{
//	Optional<BookedEvent> findByEventName(String eventName);

	@Transactional
	@Modifying 
	@Query(value = "insert into rating (review,reviewer,reviewee,review_date) VALUES (?1, ?2,?3,now())", nativeQuery = true)
	void setReview(String review,String reviewer, String reviewee);
	
	
	
	
	
}
