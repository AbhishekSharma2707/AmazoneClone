package com.ecommerceController;

import com.ecommerceEntity.Cart;
import com.ecommerceEntity.Product;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class CartItemDto {
	
	private long cartItemId;
	private long quantity;
	private double price;
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartDto getCartDto() {
		return cartDto;
	}
	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	private CartDto cartDto;
	private ProductDto productDto;

}
