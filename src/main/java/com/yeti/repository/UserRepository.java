package com.yeti.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.yeti.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

	@Transactional
	@Modifying
	@Query("UPDATE USER p SET p.password = :password, p.firstname = :firstname, p.lastname = :lastname, p.email = :email WHERE p.username = :username")
	public void updateByUsername(@Param("username") String username, @Param("password") String password,
			@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("email") String email);

	@Transactional
	@Modifying
	@Query("DELETE FROM USER p WHERE p.username = :username")
	public void deleteByUsername(@Param("username") String username);
}
                                                