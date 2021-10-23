import { Injectable } from '@angular/core';
import { JobSeeker } from './job-seeker';
import { JOB_SEEKER_LIST } from './job-seeker-list';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobSeekerService {
  constructor() { }
  getJobSeekers(): Observable<JobSeeker[]> {
    return of(JOB_SEEKER_LIST);
  }
}
