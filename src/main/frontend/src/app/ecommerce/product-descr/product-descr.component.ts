import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EcommerceService } from '../services/EcommerceService';
import { first } from 'rxjs/operators';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-product-descr',
  templateUrl: './product-descr.component.html',
  styleUrls: ['./product-descr.component.css']
})
export class ProductDescrComponent implements OnInit {
  productId: String;
  product: Product;

  constructor(
    private route: ActivatedRoute,
    private router: Router, private ecommerceService: EcommerceService) {
    this.route.params.subscribe(params => {
      this.productId = params.id;
    });
    this.loadProdDescr();
  }

  ngOnInit() {
  }

  loadProdDescr() {
    console.log(

      this.ecommerceService.
        getProductDescr(String(this.productId)).pipe(first())
        .subscribe(
          data => { console.log(data); })
    );
  }
}
