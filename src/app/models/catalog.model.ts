import {Product} from "./product.model";

export class Catalog{
  id:number
  Libelle:string
  products:Product[]

  constructor(id:number,Libelle:string,products:Product[]=[]) {
    this.id=id;
    this.Libelle=Libelle;
    this.products=products;
  }
}
