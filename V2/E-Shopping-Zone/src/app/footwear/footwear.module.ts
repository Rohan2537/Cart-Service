import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FootwearComponent } from './footwear.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'footwear', component: FootwearComponent }
     ])
     
    ],
    declarations: [
      FootwearComponent
    ]
  })


export class FootwearModule{

}