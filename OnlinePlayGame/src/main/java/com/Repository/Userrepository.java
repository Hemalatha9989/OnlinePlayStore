package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Model.User;

@Repository
public interface Userrepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
	@Query("select m from User m where m.email = :email and m.password = :password ")
	User authenticateuser(@Param("email") String email, @Param("password") String password);

}
