import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { SigninModule } from './signin/signin.module';
import { CartModule } from './cart/cart.module';
import { ElectronicsModule } from './electronics/electronics.module';
import { BooksModule } from './books/books.module';
import { ClothingModule } from './clothing/clothing.module';
import { BagsModule } from './bags/bags.module';
import { FootwearModule } from './footwear/footwear.module';
import { KitchenModule } from './kitchen/kitchen.module';
import { SportsModule } from './sports/sports.module';
import { ProductsModule } from './products/products.module';
@NgModule({
  declarations: [
    AppComponent
    

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    SigninModule,
    CartModule,
    ElectronicsModule,
    BooksModule,
    ClothingModule,
    BagsModule,
    FootwearModule,
    KitchenModule,
    SportsModule,
    ProductsModule
    // RouterModule.forRoot([
    //   {path:"signin", component:SigninComponent},
    //   { path: '', redirectTo: 'signin', pathMatch: 'full' },
    //   { path: '**', redirectTo: 'signin', pathMatch: 'full' }
      
    // ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
