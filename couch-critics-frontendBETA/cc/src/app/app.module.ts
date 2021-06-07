import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';


import { AppComponent } from './app.component';
import { DashboardComponent } from '../app/dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { AccountComponent } from './administrator/account/account.component';
import { ManageComponent } from './administrator/manage/manage.component';
import { UserAccountInfoComponent } from './user-stories/components/user-account-info/user-account-info.component';
import { UpdateUserInfoComponent } from './user-stories/components/update-user-info/update-user-info.component';
import { UserInfoComponent } from './user-stories/pages/user-info/user-info.component';
import { UserViewAMovieComponent } from './user-stories/pages/user-view-a-movie/user-view-a-movie.component';
import { UserLoggedInHomeComponent } from './user-stories/pages/user-logged-in-home/user-logged-in-home.component';
import { UserViewReviewsComponent } from './user-stories/components/user-view-reviews/user-view-reviews.component';
import { UserViewCriticsContainerComponent } from './user-stories/components/user-view-critics-container/user-view-critics-container.component';
import { UserViewCriticsPageComponent } from './user-stories/pages/user-view-critics-page/user-view-critics-page.component';
import { CriticsComponent } from './critics-stories/critics/critics.component';
import { ReviewDetailComponent } from './critics-stories/review-detail/review-detail.component';
import { MakeReviewComponent } from './critics-stories/make-review/make-review.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatTableModule} from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatSlider, MatSliderModule } from '@angular/material/slider';
import { CriticsNavBarComponent } from './critics-stories/critics-nav-bar/critics-nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    AccountComponent,
    ManageComponent,
    UserAccountInfoComponent,
    UpdateUserInfoComponent,
    UserInfoComponent,
    UserViewAMovieComponent,
    UserLoggedInHomeComponent,
    UserViewReviewsComponent,
    UserViewCriticsContainerComponent,
    UserViewCriticsPageComponent,
    CriticsComponent,
    ReviewDetailComponent,
    MakeReviewComponent,
    CriticsNavBarComponent


  ],
  imports: [
    MatInputModule,
    MatTableModule,
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    CommonModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
