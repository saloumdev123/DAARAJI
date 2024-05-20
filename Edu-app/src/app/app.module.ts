import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FooterComponent } from './footer/footer.component';
import { SchoolEventComponent } from './school-event/school-event.component';
import { SchoolGalleryComponent } from './school-gallery/school-gallery.component';
import { Router, RouterLink, RouterOutlet, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  {
    path: '/',
    component: HomeComponent,
  },
  {
    path: 'gallery',
    component: SchoolGalleryComponent,
  },
  {
    path: 'about-us',
    component: AboutUsComponent,
  },
  {
    path: 'events',
    component: SchoolEventComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SchoolEventComponent,
    SchoolGalleryComponent,
  ],
  imports: [
    NgbModule,
    RouterLink,
    RouterOutlet,
    Router,
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HeaderComponent,
    SchoolEventComponent,
    SchoolGalleryComponent,
    FooterComponent,
  ],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
