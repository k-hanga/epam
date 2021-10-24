import { Injectable } from '@angular/core';
import { JobSeeker } from './job-seeker';
import { JOB_SEEKER_LIST } from './job-seeker-list';
import { Observable, of } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {MessageService} from './message.service';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JobSeekerService {
  private jobSeekerURL = 'api/jobSeeker';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }
  private log(message: string) {
    this.messageService.add(`JobService: ${message}`);
  }
  getJobSeekers(): Observable<JobSeeker[]> {
    return of(JOB_SEEKER_LIST);
  }
  updateJobSeeker(jobSeeker: JobSeeker): Observable<any> {
    return this.http.put(this.jobSeekerURL, jobSeeker, this.httpOptions).pipe(
      tap(_ => this.log(`Updated hero#${jobSeeker.id}`)),
      catchError(this.handleError<any>('updateJobSeeker'))
    );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error);
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
