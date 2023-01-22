import {Buffer} from 'buffer';
import {Catalog} from "./catalog.model";

export class Product {
  id : number;
  designation:string;
  description:string;
  quantite_stock:Number;
  prix:number;
  image: ArrayBuffer | undefined ;
  catalog:Catalog ;

  constructor(id :number,designation :string,description :string,quantite_stock :Number,prix:number,image:ArrayBuffer |undefined,
              catalog:Catalog ){
    this.id=id;
    this.designation=designation;
    this.description=description;
    this.quantite_stock=quantite_stock;
    this.prix=prix;
    this.image=image;
    this.catalog=catalog;
  }

}
