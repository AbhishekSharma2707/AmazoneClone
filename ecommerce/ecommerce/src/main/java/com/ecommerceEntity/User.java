package com.ecommerceEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity

public class User 
{
	@Id
	String username;
	String password;
	
	long mobno; 
	
	String emailid;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public User(String username, String password, long mobno, String emailid) {
		super();
		this.username = username;
		this.password = password;
		this.mobno = mobno;
		this.emailid = emailid;
	}
	public User() {
		super();
	}
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
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", mobno=" + mobno + ", emailid=" + emailid
				+ "]";
	}
	
	
	
	
	// public boolean equals(Object obj)
	
	
	
	// userfrombrowser,this===> [username=x  password=z  mobno=0  emailid=null]   User class object from browser
	
	// userfromdatabase,secondobject,user ==>[username= x  password=y  mobno=1234  emailid=sde@fxfx ]   User class object given by get method
	
	// userfrombrowser.equals(userfromdatabase);
	
//	
//	@Override
//	public boolean equals(Object secondobject) 
//	{
//				
//		System.out.println("equals from User class");
//		
//		User user=(User)secondobject;
//		
//		if(this.username.equals(user.username) && this.password.equals(user.password))
//			
//			return true;
//		else
//			return false;
//	}
	public boolean equals(Object secondoject) {
		System.out.println("equals from User Class");
		User user=(User) secondoject;
		if(this.username.equals(user.username) && this.password.equals(user.password))
			return true;
		else
			return false;
	}
	
	
}

