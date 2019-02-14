import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { KitchenComponent } from './kitchen.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'kitchen', component: KitchenComponent }
     ])
     
    ],
    declarations: [
      KitchenComponent
    ]
  })


export class KitchenModule{

}