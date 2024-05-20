import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-school-event',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './school-event.component.html',
  styleUrl: './school-event.component.css',
})
export class SchoolEventComponent {}
