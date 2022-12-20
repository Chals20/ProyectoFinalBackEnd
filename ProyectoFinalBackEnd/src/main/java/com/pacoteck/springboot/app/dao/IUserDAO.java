package com.pacoteck.springboot.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.pacoteck.springboot.app.dto.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	public Optional<User> findByUsername(String username);
	
	@Query(value = "SELECT * FROM users WHERE users.user_name = :name",
			nativeQuery = true)
	User existName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM users WHERE email = :email",
			nativeQuery = true)
	User existEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM users WHERE "
			+ "email = :email AND password = :password",
			nativeQuery = true)
	User logIn(@Param("email") String email,@Param("password") String password);
	
	@Query(value = "UPDATE users SET password =:password WHERE id =:id",
			nativeQuery = true)
	public void UpdatePassword(@Param("id") Long id,@Param("password") String password);
	
	public Optional<User> findByEmail(String email);

}
