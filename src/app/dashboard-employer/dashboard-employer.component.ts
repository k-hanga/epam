import { Component, OnInit } from '@angular/core';
import { Job } from '../job';
import { JobService } from '../job.service';

@Component({
  selector: 'app-dashboard-employer',
  templateUrl: './dashboard-employer.component.html',
  styleUrls: ['./dashboard-employer.component.css']
})
export class DashboardEmployerComponent implements OnInit {
  jobs: Job[] = [];
  constructor(private jobService: JobService) {}
  ngOnInit() {
    this.getJobs();
  }
  getJobs(): void {
    this.jobService.getJobs().subscribe(jobs => this.jobs = jobs.slice(0, 20));
  }
}
