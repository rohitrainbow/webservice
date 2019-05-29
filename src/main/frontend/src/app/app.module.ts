import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {EcommerceComponent} from './ecommerce/ecommerce.component';
import {ProductsComponent} from './ecommerce/products/products.component';
import {ShoppingCartComponent} from './ecommerce/shopping-cart/shopping-cart.component';
import {OrdersComponent} from './ecommerce/orders/orders.component';
import {EcommerceService} from './ecommerce/services/EcommerceService';
import { LoginComponent } from './ecommerce/login/login.component';
import { RegisterComponent } from './ecommerce/register/register.component';
import { AuthenticationService } from './ecommerce/services/authentication-servie.service';
import { AlertService } from './ecommerce/services/alert-service.service';
import { PaymentComponent } from './ecommerce/payment/payment.component';
import { AboutComponent } from './ecommerce/about/about.component';
import { ContactComponent } from './ecommerce/contact/contact.component';
import { ProductDescrComponent } from './ecommerce/product-descr/product-descr.component';


const appRoutes: Routes = [
    {
      path: 'login',
      component: LoginComponent,
      data: { title: 'Login' }
    },
    {
      path: '',
      redirectTo: '/home',
      pathMatch: 'full'
    },
    {
      path: 'home',
      component: EcommerceComponent,
      data: { title: 'Home' }
    },
    {
        path: 'register',
        component: RegisterComponent,
        data: { title: 'Register' }
      },
      {
        path: 'payment',
        component: PaymentComponent,
        data: { title: 'payment' }
      },
      {
        path: 'about',
        component: AboutComponent,
        data: { title: 'About Us' }
      },
      {
        path: 'contact',
        component: ContactComponent,
        data: { title: 'Contact Us' }
      },
      {
        path: 'productdetails/:id',
        component: ProductDescrComponent,
        data: { title: 'Product Details' }
      }
  ];

@NgModule({
    declarations: [
        AppComponent,
        EcommerceComponent,
        ProductsComponent,
        ShoppingCartComponent,
        OrdersComponent,
        LoginComponent,
        RegisterComponent,
        PaymentComponent,
        AboutComponent,
        ContactComponent,
        ProductDescrComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule.forRoot(appRoutes, { useHash: true })
    ],
    providers: [EcommerceService,AuthenticationService,AlertService],
    bootstrap: [AppComponent]
})
export class AppModule {
}