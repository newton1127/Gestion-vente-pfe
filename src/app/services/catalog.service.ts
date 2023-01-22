import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Catalog } from '../models/catalog.model';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {

  private baseUrl = 'http://localhost:8889/PRODUCT-SERVICE/catalogs';

  constructor(private http: HttpClient) { }

  getCatalog(id: number): Observable<Catalog> {
    return this.http.get<Catalog>(`${this.baseUrl}/${id}`);
  }

  createCatalog(catalog: Catalog): Observable<Catalog> {
    return this.http.post<Catalog>(`${this.baseUrl}`, catalog);
  }

  updateCatalog(id: number, value: Catalog): Observable<Catalog> {
    return this.http.put<Catalog>(`${this.baseUrl}/${id}`, value);
  }

  deleteCatalog(id: number): Observable<Catalog> {
    return this.http.delete<Catalog>(`${this.baseUrl}/${id}`);
  }

  getCatalogsList(): Observable<Catalog[]> {
    return this.http.get<Catalog[]>(`${this.baseUrl}`);
  }
}
