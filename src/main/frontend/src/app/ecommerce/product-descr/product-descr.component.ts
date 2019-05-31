import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EcommerceService } from '../services/EcommerceService';
import { first } from 'rxjs/operators';
import { Product } from '../models/product.model';
import { ProdDescr } from '../models/prod-descr.model';

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
      this.product=new Product(1,"ITS",9999,"",new ProdDescr(1,"",1));
    this.route.params.subscribe(params => {
      this.productId = params.id;
    });
   
  }

  ngOnInit() {
    this.loadProdDescr();
  }

  loadProdDescr() {

    this.ecommerceService.
      getProductDescr(String(this.productId)).pipe(first())
      .subscribe(
        data => {
          this.product = data; // use this variable as object
        });
        }

        
}
