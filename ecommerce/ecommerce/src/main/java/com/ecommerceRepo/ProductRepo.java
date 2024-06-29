package com.ecommerceRepo;


import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceEntity.Product;
import com.ecommerceEntity.User;

public interface ProductRepo  extends JpaRepository<Product, Long>{
//	Page<Product> findByCategory(Category catgoty,Pageable pageable);
	public Optional<Product>findByUsername(String username);
	public   Product findById(long productId);

}
