import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ButtonComponent } from './components/button/button.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { UpdateUserInfoComponent } from './components/update-user-info/update-user-info.component';
import { MovieReviewComponent } from './components/movie-review/movie-review.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    ButtonComponent,
    HeaderComponent,
    FooterComponent,
    UpdateUserInfoComponent,
    MovieReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
