import { Component, OnInit } from '@angular/core';
import { ProductOrders } from '../models/product-orders.model';
import { Subscription } from 'rxjs/internal/Subscription';
import { EcommerceService } from '../services/EcommerceService';
import { Payment } from '../models/payment';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';


@Component({
    selector: 'app-orders',
    templateUrl: './orders.component.html',
    styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
    orders: ProductOrders;
    total: number;
    paid: boolean;
    payment: Payment;
    sub: Subscription;

    constructor(private ecommerceService: EcommerceService, private router: Router) {
        this.orders = this.ecommerceService.ProductOrders;
    }

    ngOnInit() {
        this.paid = false;
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.orders = this.ecommerceService.ProductOrders;
        });
        this.loadTotal();
    }

    pay() {
        this.paid = true;
        this.payment = new Payment();
        this.payment.custId = '5544';
        this.ecommerceService.saveOrder(this.orders).subscribe();
        this.ecommerceService.
            redirectPayment(this.payment).pipe(first())
            .subscribe(
                data => {
                    localStorage.setItem('paymentRedirect', data);
                },
                error => {
                    console.log(error);
                });
                this.router.navigate(['/payment']);
    }

    loadTotal() {
        this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
            this.total = this.ecommerceService.Total;
        });
    }
}