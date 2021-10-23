import {Injectable} from '@angular/core';
import {JobSeeker} from './jobseeker';
import {JOBSEEKERS} from './users';
import {Observable, of} from 'rxjs';
import {MessageService} from './message.service';

@Injectable({
  providedIn: 'root'
})
export class JobseekerService {
  constructor(private messageService: MessageService) { }
  getJobSeekers(): Observable<JobSeeker[]> {
    this.messageService.add('JobSeekerService: fetched heroes');
    return of(JOBSEEKERS);
  }
}
