import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Job } from '../job';
import { JobService } from '../job.service';
import { Employer } from '../employer';
import { EmployerService } from '../employer.service';
import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-jobdetails',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
  @Input() job?: Job;
  @Input() employer: Employer;
  constructor(
    private route: ActivatedRoute,
    private jobService: JobService,
    private employerService: EmployerService,
    private location: Location
  ) { }
  ngOnInit(): void {
    this.getJob();
    // this.getEmployer();
  }
  getJob(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.jobService.getJob(id).subscribe( job => this.job = job );
  }
  getEmployer(): void {
    this.employerService.getEmployer(this.job.employer).subscribe( employer => this.employer = employer );
  }
  goBack(): void {
    this.location.back();
  }
}
