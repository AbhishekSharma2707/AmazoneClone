package com.ecommerceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceController.CartDto;
import com.ecommerceController.ItemRequest;
import com.ecommerceEntity.Cart;
import com.ecommerceEntity.CartItem;
import com.ecommerceEntity.Product;
import com.ecommerceEntity.User;
import com.ecommerceRepo.ProductRepo;
import com.ecommerceRepo.UserRepo;

@Service
public class CartService {
	@Autowired
	UserRepo user;
	
	@Autowired
	ProductRepo productRepo;

	public CartDto addItem(ItemRequest item,String username) {
		long productId = item.getProductId();
		long quantity = item.getQuantity();
		User user = this.user.findByUsername(username).orElseThrow();
		Product product=this.productRepo.findById(productId);
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		double totalPrice = product.getProductPrice()*product.getProductQuantity();
		cartItem.setPrice(totalPrice);
		
		Cart cart = user.getCart();
		
		if (cart==null) {
			Cart cart1 = new Cart();
		}
		
		
		
		
		return null;
	}
}
