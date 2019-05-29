import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-descr',
  templateUrl: './product-descr.component.html',
  styleUrls: ['./product-descr.component.css']
})
export class ProductDescrComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router) {
      this.route.params.subscribe(params => {
        console.log(params.id);
      });
  }

  ngOnInit() {
  }

}
