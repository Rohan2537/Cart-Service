import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SportsComponent } from './sports.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'sports', component: SportsComponent }
     ])
     
    ],
    declarations: [
      SportsComponent
    ]
  })


export class SportsModule{

}