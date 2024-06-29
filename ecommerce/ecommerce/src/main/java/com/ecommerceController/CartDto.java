package com.ecommerceController;

import java.util.HashSet;
import java.util.Set;

import com.ecommerceEntity.CartItem;


import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class CartDto {
	
	private long cartId;
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public Set<CartItemDto> getItems() {
		return items;
	}
	public void setItems(Set<CartItemDto> items) {
		this.items = items;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	private Set<CartItemDto> items = new HashSet<>(); 
	private UserDto user;

}
