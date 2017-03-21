package com.yeti.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yeti.model.UsersDetails;

@Repository
public interface UsersDetailsRepository extends CrudRepository<UsersDetails, Long> {
	
	@Query("SELECT p FROM users_details p WHERE p.users.username = :username")
	public UsersDetails findUser(
			@Param("username") String username);

	/*	@Transactional
	@Modifying
	@Query("UPDATE USERS_DETAILS p SET p.password = :password, p.firstname = :firstname, p.lastname = :lastname, p.email = :email WHERE p.username = :username")
	public void updateByUsername(@Param("username") String username, @Param("password") String password,
			@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("email") String email);

	@Transactional
	@Modifying
	@Query("DELETE FROM USERS p WHERE p.username = :username")
	public void deleteByUsername(@Param("username") String username);*/
}
                                                