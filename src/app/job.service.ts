import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {JOB_LISTING} from './job_listing';
import {Job} from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  constructor() { }
  getJobs(): Observable<Job[]> {
    return of(JOB_LISTING);
  }
  getJob(id: number): Observable<Job> {
    const job = JOB_LISTING.find(j => j.id === id)!;
    return of(job);
  }
}
