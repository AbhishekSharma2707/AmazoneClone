import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  products = [
    {
      id: 1,
      name: 'Product 1',
      img: '../.../../assets/images/box2_image.jpg',
      price: 1000
    },
    {
      id: 2,
      name: 'Product 2',
      img: '../.../../assets/images/box6_image.jpg',
      price: 2000
    },
    {
      id: 3,
      name: 'Product 3',
      img: '../.../../assets/images/box5_image.jpg',
      price: 3000
    }
  ];

  constructor(private router:Router)
  {

  }
  addToCart()
  {
      this.router.navigateByUrl("cart");
      Swal.fire('Sucess','Product Added to Cart ')

  }
  

}
