import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {Course} from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private coursesURL = 'http://gyorik.sch.bme.hu:8080/api/courses';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }
  private log(message: string) {
    this.messageService.add(`CourseService: ${message}`);
  }
  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.coursesURL).pipe(
      tap(_ => this.log('Fetched courses')),
      catchError(this.handleError<Course[]>('getCourses', []))
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
  getCourse(id: number): Observable<Course> {
    const url = `${this.coursesURL}/${id}`;
    return this.http.get<Course>(url).pipe(
      tap(_ => this.log(`Fetched course#${id}`)),
      catchError(this.handleError<Course>(`getCourse id=${id}`))
    );
  }
  updateCourse(course: Course): Observable<any> {
    return this.http.put(`${this.coursesURL}/${course.id}`, course, this.httpOptions).pipe(
      tap(_ => this.log(`Updated course#${course.summary}`)),
      catchError(this.handleError<any>('updateCourse'))
    );
  }
}
