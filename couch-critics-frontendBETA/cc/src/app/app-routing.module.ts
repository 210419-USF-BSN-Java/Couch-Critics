import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserInfoComponent } from "./user-stories/pages/user-info/user-info.component"; 
import { UserLoggedInHomeComponent } from './user-stories/pages/user-logged-in-home/user-logged-in-home.component';
import { UserViewCriticsPageComponent } from './user-stories/pages/user-view-critics-page/user-view-critics-page.component';
import { UserViewAMovieComponent } from './user-stories/pages/user-view-a-movie/user-view-a-movie.component';
import { CriticsComponent } from './critics-stories/critics/critics.component';
import { MakeReviewComponent } from './critics-stories/make-review/make-review.component';
import { ReviewDetailComponent } from './critics-stories/review-detail/review-detail.component';
import { ManageComponent } from './administrator/manage/manage.component';
import { ViewAllEmployeesComponent } from './administrator/view-all-employees/view-all-employees.component';
import { ViewAllUsersComponent } from './administrator/view-all-users/view-all-users.component';
import { ViewApprovedReviewsComponent } from './administrator/view-approved-reviews/view-approved-reviews.component';
import { ViewPendingReviewsComponent } from './administrator/view-pending-reviews/view-pending-reviews.component';

const routes: Routes = [
  {path: '', component:DashboardComponent},
  {path: 'login', component:LoginComponent}, 
  {path: 'usersetting', component:UserInfoComponent},
  {path: 'userhome', component: UserLoggedInHomeComponent}, 
  {path: "CriticMovieReview/:id", component: UserViewAMovieComponent},
  {path: 'usercritics', component: UserViewCriticsPageComponent}, 
  {path: 'userMovie', component:UserViewAMovieComponent},
  { path: 'critics', component: CriticsComponent },
  { path: 'create', component : MakeReviewComponent},
  { path: 'detail/:id', component : ReviewDetailComponent},
  { path: 'admin', component : ManageComponent},
  { path: 'view-employees', component : ViewAllEmployeesComponent},
  { path: 'view-users', component : ViewAllUsersComponent},
  { path: 'view-approved-reviews', component : ViewApprovedReviewsComponent},
  { path: 'view-pending-reviews', component : ViewPendingReviewsComponent},
  { path: '**', component: LoginComponent  }


];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
