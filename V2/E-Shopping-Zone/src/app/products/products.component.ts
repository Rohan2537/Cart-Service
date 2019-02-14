import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component
({
    templateUrl: "./products.component.html",
    styleUrls: ['./products.component.css']
})
export class ProductsComponent{

    private url="http://localhost:8989/products"
    products:any;

    constructor(private http : HttpClient){

    }
    
    search()
    {
        this.http.get("url")
        .subscribe((products)=>{
            this.products=products;
            console.log(products);
        })
    }
}