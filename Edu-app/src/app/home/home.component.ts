import { Component } from '@angular/core';
import { AboutUsComponent } from '../about-us/about-us.component';
import { SchoolEventComponent } from '../school-event/school-event.component';
import { SchoolGalleryComponent } from '../school-gallery/school-gallery.component';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    AboutUsComponent,
    SchoolEventComponent,
    SchoolGalleryComponent,
    HeaderComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
