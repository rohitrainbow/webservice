export class ProdDescr {
    descrId: number;
    descr: string;
    productId: number;

    constructor(descrId: number, descr: string, productId:number) {
        this.descrId = descrId;
        this.descr = descr;
        this.productId=productId;
    }
}
