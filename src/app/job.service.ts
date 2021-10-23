import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {JobList} from './job-list';
import {Job} from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  constructor() { }
  getJobs(): Observable<Job[]> {
    return of(JobList);
  }
  getJob(id: number): Observable<Job> {
    const job = JobList.find(j => j.id === id)!;
    return of(job);
  }
}
