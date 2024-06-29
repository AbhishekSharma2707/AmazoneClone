package com.ecommerceController;


import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceEntity.Admin;
import com.ecommerceEntity.Product;
import com.ecommerceEntity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController 
{
		@Autowired//The @Autowired annotation in Spring is used for automatic dependency injection.
		//To use @Autowired successfully, you typically configure the SessionFactory as a bean in your Spring configuration.
		SessionFactory factory;
		
		static HttpSession httpsession;
		//HttpSession allows you to store and retrieve user-specific information across multiple HTTP requests. It represents a way to maintain stateful information for a particular user session on the server side.
		//Once you have the HttpSession object (httpsession), you can use it to store and retrieve attributes specific to the user's session:
		//{"username":"x","password":"z"}
		
		@PostMapping("validate")
		public boolean validate(@RequestBody User userfromBrowser,HttpServletRequest request)
		{   
			
//			purpose: @RequestBody is used to extract the body of an incoming HTTP request and convert it into a Java object (or another type) that you can work with in your Spring MVC controller method.
			//The @RequestBody annotation in Spring MVC is used to bind the body of an HTTP request to a method parameter in a controller. Here's a simple explanation of how @RequestBody works:
			httpsession=request.getSession();
						
			Session session=factory.openSession();
			
			User userfromdb=session.get(User.class,userfromBrowser.getUsername());
			
			
			// userfromBrowser==> [username=x password=z] User class obejct from browser
			
			// userfromdb==> [username=x password=y] User class obejct from Database
			
			
			boolean answer=userfromBrowser.equals(userfromdb);
			
			if(answer)
			{
				httpsession.setAttribute("score",0);
				
				httpsession.setAttribute("questionIndex",0);
				
				HashMap<Integer, Product> hashmap=new HashMap<>();
				
				httpsession.setAttribute("submittedDetails", hashmap);				
			}
			return answer;
		}
		
/* below API will validate Admin user  */
		
		@PostMapping("validate2")
		public Boolean validate2(@RequestBody Admin userfrombrowser,HttpServletRequest request)
		{
			
			System.out.println("user from browser " + userfrombrowser);
		
			Session session=factory.openSession();
			
			Admin userfromdatabase=session.get(Admin.class,userfrombrowser.getUsername());
			
			System.out.println("user from database " +userfromdatabase);
						
			// this refers to that object which is used to call method
			
			if(userfromdatabase==null)
			{
				return false;
			}
			
			boolean answer=userfrombrowser.equals(userfromdatabase);
					
			System.out.println("answer from equals() of Object class is " + answer);
				
			return answer;
					
		}
}
