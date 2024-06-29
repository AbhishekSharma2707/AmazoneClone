import { Component, OnInit } from '@angular/core';
import { User, UserService } from '../user.service';
import { Admin, AdminService } from '../admin.service';
import { Router } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminlogin',
  standalone: true,
  imports: [FormsModule,CommonModule,MatFormFieldModule, MatInputModule,MatIconModule,MatButtonModule,FormsModule,CommonModule,MatSnackBarModule,MatCardModule,MatSelectModule],
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent  {

 


    subjects:string[]=[];
    subject:string='';
    user:User=new User('','',0,'');
    admin:Admin=new Admin('','');
    message:string="";
    constructor(private userService:UserService,private router:Router,private adminService:AdminService){
  
    }
    validate2()
  {
    this.admin.username=this.user.username;
    this.admin.password=this.user.password;

      this.adminService.validate2(this.admin).subscribe(answer=>{if(answer)
      {
        Swal.fire('Sucess','Admin Logged in!')
        this.router.navigate(['admindashboard']);

      }
    
      else
      {
        this.router.navigate(['adminlogin']);
        this.message="invalid credentials";
        Swal.fire('Failed','Adminn Loginn Failed | Please try again')
        
      }
    });
  }
}
