package com.ecommerceController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceEntity.Product;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
	SessionFactory sf;

//	PostMapping indicate that client must use HTTP request method post while requesting this API
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
				
		s.persist(product);
		
		t.commit();
		
		return "Product saved";
		}
	
	// View all Products
	@GetMapping("viewProduct/{productId}")
	public Product viewProduct(@PathVariable Integer productId) {
		Session s = sf.openSession();
		
		Query query = s.createQuery("from Product where productId=:productId");
		query.setParameter("productId", productId);
		
		Product product = (Product)query.uniqueResult();
		
		return product;
		
	}
	
	//DeleteProduct by ID
	@DeleteMapping("deleteProduct/{productId}")
	public boolean deleteProduct(@PathVariable Integer productId)
	{
		Session s = sf.openSession();
		
		Query<Product> query=s.createQuery("from Product where productId=:productId ");
		query.setParameter("productId",productId);
	
		Product product=query.uniqueResult();
		
		Transaction t=s.beginTransaction();
		
			s.remove(product);
		
		t.commit();
		
		return true;
		
	}
	
//	UpdateProduct by ID
	@PutMapping("updateProduct")
	public boolean updateProduct(@RequestBody Product product)
	{
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
			s.merge(product);
			
		t.commit();
		
		return true;
			
	}
	
}
