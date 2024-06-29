import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient,private router:Router) { 

  }
  addProduct(product:Product){
    return this.httpClient.post("http://localhost:8080/addProduct",product);
  }

  viewProduct(productId:number)
   {
    return this.httpClient.get<Product>("http://localhost:8080/viewProduct/"+productId);
   }

  updateProduct(product:Product) 
   {
    return this.httpClient.put<boolean>("http://localhost:8080/updateProduct" , product);
   }

  deleteProduct(productId:number)
  {
    return this.httpClient.delete<boolean>("http://localhost:8080/deleteProduct/"+productId);
  }
}

export class Product{
  productId:number;
  productName:string;
  productPrice:number;
  productInfo:string;
  img:string;
  productQuantity:number;

  constructor( productId:number,productName:string,productPrice:number,productInfo:string,img:string,productQuantity:number){

    this.productId=productId;
    this.productName=productName;
    this.productPrice=productPrice;
    this.productInfo=productInfo;
    this.img=img;
    this.productQuantity=productQuantity;

  }
}