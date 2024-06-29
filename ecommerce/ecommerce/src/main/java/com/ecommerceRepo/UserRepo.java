package com.ecommerceRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerceEntity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	public Optional<User>findByUsername(String username);
	 public   List<User>findByEmail(String email);
	  public User findByUsernameAndPassword(String username,String password);
	   public   List<User>findByActiveTrue();
       public    List<User>    findByAboutIsNotNull();
       public List<User> findByNameStartingWith(String prifix);
       public List<User> findByNameContaining(String infix);
       public List<User> findByNameLike(String like);
       

       
       
       // Createing Query Method
       @Query("select u from User u")
       public List<User> getAllUser();

}
