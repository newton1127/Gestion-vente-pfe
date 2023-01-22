import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductComponent} from "./components/products/products.component";
import {CatalogComponent} from "./components/catalogs/catalogs.component";
import {AppComponent} from "./app.component";


const routes: Routes = [
  {path:'products',component:ProductComponent},
  {path:'catalogs',component: CatalogComponent},
  {path:'',component: AppComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
