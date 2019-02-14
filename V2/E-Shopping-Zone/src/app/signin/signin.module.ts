import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SigninComponent} from './signin.component';
import { SignupModule} from './signup/signup.module'

@NgModule({
    imports: [
      RouterModule.forChild([
        { path: 'signin', component: SigninComponent }
     ]),
     SignupModule
    ],
    declarations: [
        SigninComponent
    ]
  })
export class SigninModule {

}