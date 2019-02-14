import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ElectronicsComponent } from './electronics.component'
@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'electronics', component: ElectronicsComponent }
     ])
     
    ],
    declarations: [
        ElectronicsComponent
    ]
  })


export class ElectronicsModule{

}