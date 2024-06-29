package com.ecommerceController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceEntity.User;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController 
{
		@Autowired
		SessionFactory factory;
	
		@PostMapping("saveToDB")
		public void saveToDB(@RequestBody User user)
		{
			System.out.println(user);
			
			Session session=factory.openSession();
			
			Transaction tx=session.beginTransaction();
				
					session.persist(user);
			
			tx.commit();
			
		}

}
