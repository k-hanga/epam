import { Injectable } from '@angular/core';
import { Employer } from './employer';
import { EMPLOYER_LIST } from './employer-list';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployerService {
  constructor() { }
  getEmployers(): Observable<Employer[]> {
    return of(EMPLOYER_LIST);
  }
  getEmployer(id: number): Observable<Employer> {
    return of(EMPLOYER_LIST[id]);
  }
}
