import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoolEventComponent } from './school-event.component';

describe('SchoolEventComponent', () => {
  let component: SchoolEventComponent;
  let fixture: ComponentFixture<SchoolEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SchoolEventComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SchoolEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
