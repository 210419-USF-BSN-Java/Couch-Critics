import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserInfoComponent } from "./user-stories/pages/user-info/user-info.component"; 
import { UserLoggedInHomeComponent } from './user-stories/pages/user-logged-in-home/user-logged-in-home.component';
import { UserViewCriticsPageComponent } from './user-stories/pages/user-view-critics-page/user-view-critics-page.component';
import { UserViewAMovieComponent } from './user-stories/pages/user-view-a-movie/user-view-a-movie.component';

const routes: Routes = [
  {path: '', component:DashboardComponent},
  {path: 'login', component:LoginComponent}, 
  {path: 'usersetting', component:UserInfoComponent},
  {path: 'userhome', component: UserLoggedInHomeComponent}, 
  {path: 'usercritics', component: UserViewCriticsPageComponent}, 
  {path: 'userMovie', component:UserViewAMovieComponent}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
