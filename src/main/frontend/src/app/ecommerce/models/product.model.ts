import { ProdDescr } from "./prod-descr.model";

export class Product {
	id: number;
    name: string;
    price: number;
    pictureUrl: string;
    prodDescr:ProdDescr;
    
    constructor(id: number, name: string, price: number, pictureUrl: string,prodDescr:ProdDescr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.prodDescr=prodDescr;
    }

}
