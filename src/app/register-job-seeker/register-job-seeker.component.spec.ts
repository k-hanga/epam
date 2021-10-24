import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterJobSeekerComponent } from './register-job-seeker.component';

describe('RegisterJobSeekerComponent', () => {
  let component: RegisterJobSeekerComponent;
  let fixture: ComponentFixture<RegisterJobSeekerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterJobSeekerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterJobSeekerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
