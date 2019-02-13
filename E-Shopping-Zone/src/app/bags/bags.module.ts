import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BagsComponent } from './bags.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'bags', component: BagsComponent }
     ])
     
    ],
    declarations: [
      BagsComponent
    ]
  })


export class BagsModule{

}