import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {User} from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersURL = 'http://gyorik.sch.bme.hu:8080/api/users';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }
  private log(message: string) {
    this.messageService.add(`UserService: ${message}`);
  }
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersURL).pipe(
      tap(_ => this.log('Fetched users')),
      catchError(this.handleError<User[]>('getUsers', []))
    );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error);
      // TODO: better user of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
  getUser(id: number): Observable<User> {
    const url = `${this.usersURL}/${id}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.log(`Fetched user#${id}`)),
      catchError(this.handleError<User>(`getUser id=${id}`))
    );
  }
  updateUser(user: User): Observable<any> {
    return this.http.put(`${this.usersURL}/${user.id}`, user, this.httpOptions).pipe(
      tap(_ => this.log(`Updated user#${user.username}`)),
      catchError(this.handleError<any>('updateUser'))
    );
  }
  createUser(user: User): Observable<any> {
    console.error(user);
    var a = this.http.post(`${this.usersURL}`, user, this.httpOptions).pipe(
      tap(_ => this.log(`Created user#${user.username}`)),
      catchError(this.handleError<any>('createUser'))
    );
    console.error(a)
    return a;
  }
}
