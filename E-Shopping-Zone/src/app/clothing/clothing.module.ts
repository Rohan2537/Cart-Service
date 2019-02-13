import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ClothingComponent } from './clothing.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'clothing', component: ClothingComponent }
     ])
     
    ],
    declarations: [
        ClothingComponent
    ]
  })


export class ClothingModule{

}