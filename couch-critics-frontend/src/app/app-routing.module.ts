import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterForAccountComponent} from './components/register-for-account/register-for-account.component';

const routes: Routes = [
  //url endpoint for login page /login
  { path: '/users/login', component: LoginComponent},
  //url endpoint for regist for account page /register
  { path: '/users/register', component: RegisterForAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
//this makes it so we can use routing on other components
export class AppRoutingModule { }
