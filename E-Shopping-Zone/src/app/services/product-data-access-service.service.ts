import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './Product';
@Injectable({
  providedIn: 'root'
})
export class ProductDataAccessServiceService {
  private producturl='http://localhost:8989/products';

  constructor(private http:HttpClient) { }
  
  getProducts():Observable <Product[]> {
    return this.http.get<Product[]>(this.producturl);
  }
  getProductById(productId:number):Observable <Product> {
    const url= `${this.producturl}/${productId}`;
    return this.http.get<Product>(url);
  }
  
}
