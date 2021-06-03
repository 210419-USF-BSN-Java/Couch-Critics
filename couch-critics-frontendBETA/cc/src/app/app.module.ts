import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { AccountComponent } from './administrator/account/account.component';
import { ManageComponent } from './administrator/manage/manage.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { UserAccountInfoComponent } from './user-stories/components/user-account-info/user-account-info.component';
import { UpdateUserInfoComponent } from './user-stories/components/update-user-info/update-user-info.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    AccountComponent,
    ManageComponent,
    ReviewsComponent,
    UserAccountInfoComponent,
    UpdateUserInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
