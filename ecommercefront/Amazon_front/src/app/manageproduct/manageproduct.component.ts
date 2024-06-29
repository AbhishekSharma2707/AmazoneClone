import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product, ProductService } from '../product.service';
import { Router } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';


import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatCardModule} from '@angular/material/card';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-manageproduct',
  standalone: true,
  imports: [FormsModule,CommonModule,MatFormFieldModule, MatInputModule,MatIconModule,MatButtonModule,FormsModule,CommonModule,MatSnackBarModule,MatCardModule],
  templateUrl: './manageproduct.component.html',
  styleUrl: './manageproduct.component.css'
})
export class ManageproductComponent {

  message:string="";

  product:Product=new Product(0,"",0,"","",0);
  
  constructor(private productservice:ProductService, private router:Router){

  }
  // ngOnInit(): void {
  //   this.viewProduct();
  // }

  addProducts(){
    this.productservice.addProduct(this.product).subscribe(product=>this.message="Product Saved");
    // this.message="Product Added Succesfully....";
    Swal.fire('Success','Product Saved Successfully')
    this.router.navigate(['admindashboard']);
    
  }

  viewProduct()
  {
    this.productservice.viewProduct(this.product.productId).subscribe(product=>this.product=this.product);
    // this.router.navigate(['admindashboard']);
    Swal.fire('Success','Product View Successfully')
  }


  updateProduct()
  {
    this.productservice.updateProduct(this.product).subscribe(product=>this.message="Product updated");
    // this.router.navigate(['admindashboard']);
    // this.questionService.updateQuestion(this.question).subscribe(answer=>this.message="question updated");
    Swal.fire('Success','Product Updated Successfully')
  }

  deleteProduct()
  {
    this.productservice.deleteProduct(this.product.productId).subscribe(product=>this.message="Product Deleted");
    // this.router.navigate(['admindashboard']);
    // this.questionService.deleteQuestion(this.question.qno,this.question.subject).subscribe(answer=>this.message="question deleted");
    Swal.fire('Success','Product Deleted Successfully')
  }
}
