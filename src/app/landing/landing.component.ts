import { Component, OnInit } from '@angular/core';
import { JobSeeker } from '../job-seeker';
import { JobSeekerService } from '../job-seeker.service';
import { MessageService } from '../message.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  jobseekers: JobSeeker[] = [];
  selectedJobseeker?: JobSeeker;
  onSelect(jobseeker: JobSeeker): void {
    this.selectedJobseeker = jobseeker;
    this.messageService.add(`LandingComponent: Selected jobseeker id=${jobseeker.id}`);
  }
  constructor(
    private jobseekerService: JobSeekerService,
    private messageService: MessageService,
    private app: AppComponent
  ) { }
  ngOnInit() {
    this.getJobseekers();
  }
  getJobseekers(): void {
    this.jobseekerService.getJobSeekers().subscribe(jobseekers => this.jobseekers = jobseekers);
  }
}
