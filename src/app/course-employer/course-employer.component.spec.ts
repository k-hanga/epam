import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseEmployerComponent } from './course-employer.component';

describe('CourseEmployerComponent', () => {
  let component: CourseEmployerComponent;
  let fixture: ComponentFixture<CourseEmployerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseEmployerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseEmployerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
