package org.loginAuth.repository;

import java.util.List;

import org.loginAuth.model.Organizer;
import org.loginAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	Organizer save(Organizer organizer);
	
	@Query(value = "select * from user where id in (select id from role where name='ROLE_ORGANIZER')", nativeQuery = true)
    List<User> findUsersByRole();

	
	@Transactional
	@Modifying
	@Query(value = "update user set first_name = ?1, last_name = ?2 where id = ?3", nativeQuery = true)
	void setUserInfoById(String firstname, String lastname, Long userId);
	
}

