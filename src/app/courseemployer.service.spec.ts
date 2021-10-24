import { TestBed } from '@angular/core/testing';

import { CourseemployerService } from './courseemployer.service';

describe('CourseemployerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CourseemployerService = TestBed.get(CourseemployerService);
    expect(service).toBeTruthy();
  });
});
