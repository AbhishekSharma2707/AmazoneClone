import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

import { AdmindashboardComponent } from './admindashboard/admindashboard.component';

import { HomepageComponent } from './homepage/homepage.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { ProductComponent } from './product/product.component';
import { ManageproductComponent } from './manageproduct/manageproduct.component';
import { CartComponent } from './cart/cart.component';

export const routes: Routes = [

    {path:'',component:HomepageComponent},
    {path:'register',component:RegisterComponent},
    {path:'login',component:LoginComponent},
    {path:'cart',component:CartComponent},
    {path:'admindashboard',component:AdmindashboardComponent},


    {path:'adminlogin',component:AdminloginComponent},
    {path:'product',component:ProductComponent},
    {path:'manageproduct',component:ManageproductComponent},
    {path:'viewProduct',component:ManageproductComponent},
    {path:'updateProduct',component:ManageproductComponent},
    {path:'deleteProduct',component:ManageproductComponent},

];
