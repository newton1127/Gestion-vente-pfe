import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from '../../models/product.model';
import {Catalog} from "../../models/catalog.model";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  selectedProduct?: Product ;
  editProduct?: Product;
  newProduct?: Product;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.productService.getProductsList().subscribe(data => {
      this.products = data;
    });
  }

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  onEdit(product: Product): void {
    this.editProduct = product;
  }

  onDelete(product: Product): void {
    this.productService.deleteProduct(product.id).subscribe(data => {
      this.reloadData();
    });
  }

  onUpdate(): void {
    if (this.editProduct) {
      this.productService.updateProduct(this.editProduct.id, this.editProduct).subscribe(data => {
        this.reloadData();
      });
    }
  }

  onCreate(): void {
    if (this.newProduct) {
      this.productService.createProduct(this.newProduct).subscribe(data => {
        this.reloadData();
      });
    }
  }

  gotoList(): void {
    /*if (this.editProduct) {
      this.editProduct = null;
    }
    if (this.selectedProduct) {
      this.selectedProduct = null;
    }*/
    this.newProduct = new Product(0, "","", 0, 0, new ArrayBuffer(0), new Catalog(0,"",[]));
  }


}
