import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  paymentRedirect: any;

  constructor() { }

  ngOnInit() {
    this.paymentRedirect = localStorage.getItem('paymentRedirect');
  }

}
