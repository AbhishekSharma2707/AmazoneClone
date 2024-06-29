package com.ecommerceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Admin{
		@Id
		String username;
		String password;
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "Admin [username=" + username + ", password=" + password + "]";
		}
		
		
		public boolean equals(Object secondobject) 
		{
					
			System.out.println("equals from User class");
			
			Admin user=(Admin)secondobject;
			
			if(this.username.equals(user.username) && this.password.equals(user.password))
				
				return true;
			else
				return false;
		}

	}


