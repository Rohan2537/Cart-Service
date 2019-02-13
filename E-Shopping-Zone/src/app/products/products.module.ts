import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProductsComponent } from './products.component';

@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'home', component: ProductsComponent }
     ]),
        FormsModule,
        

    ],
    declarations: [
        ProductsComponent
    ]
  })
export class ProductsModule{
    ngOnInit(){
        
    }
}