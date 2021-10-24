import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {Job} from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private jobsURL = 'http://gyorik.sch.bme.hu:8080/api/jobs';
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
  getJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(this.jobsURL).pipe(
      tap(_ => this.log('Fetched jobs')),
      catchError(this.handleError<Job[]>('getJobs', []))
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
  getJob(id: number): Observable<Job> {
    const url = `${this.jobsURL}/${id}`;
    return this.http.get<Job>(url).pipe(
      tap(_ => this.log(`Fetched job#${id}`)),
      catchError(this.handleError<Job>(`getJob id=${id}`))
    );
  }
  updateJob(job: Job): Observable<any> {
    return this.http.put(`${this.jobsURL}/${job.id}`, job, this.httpOptions).pipe(
      tap(_ => this.log(`Updated job#${job.summary}`)),
      catchError(this.handleError<any>('updateJob'))
    );
  }
}
