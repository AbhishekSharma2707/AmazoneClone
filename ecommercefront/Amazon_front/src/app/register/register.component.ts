
import { Component } from '@angular/core';

import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatCardModule} from '@angular/material/card';
import { User, UserService } from '../user.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule,CommonModule,MatFormFieldModule, MatInputModule,MatIconModule,MatButtonModule,FormsModule,CommonModule,MatSnackBarModule,MatCardModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user:User=new User('','',0,'');

  constructor(private userService:UserService,private router:Router){

  }
  saveToDB(){
    this.userService.saveToDB(this.user).subscribe();
    Swal.fire('Sucess','user is registered! please login To Continue..')
    this.router.navigate(['login']);

  }
}
