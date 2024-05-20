import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-school-gallery',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './school-gallery.component.html',
  styleUrl: './school-gallery.component.css',
})
export class SchoolGalleryComponent {}
