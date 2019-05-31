import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-buy-now',
  templateUrl: './buy-now.component.html',
  styleUrls: ['./buy-now.component.css']
})
export class BuyNowComponent implements OnInit {

  productId: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router) {

    this.route.params.subscribe(params => {
      this.productId = params.id;
    });

  }

  ngOnInit() {
  }

}
