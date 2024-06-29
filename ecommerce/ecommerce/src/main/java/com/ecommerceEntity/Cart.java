package com.ecommerceEntity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	public Cart(long cartId) {
		super();
		this.cartId = cartId;
	}
	
	@Id
	private long cartId;
	
	//Relation with other Table
	@OneToMany
	private Set<CartItem> items = new HashSet<>(); 
	
	@OneToOne
	private User user;

	public Cart(long cartId, Set<CartItem> items) {
		super();
		this.cartId = cartId;
		this.items = items;
	}
	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Set<CartItem> getItems() {
		return items;
	}

	public void setItems(Set<CartItem> items) {
		this.items = items;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	

}
