import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { JobService } from '../job.service';
import { Component, Input, OnInit } from '@angular/core';
import { Job } from '../job';

@Component({
  selector: 'app-jobdetails',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
  @Input() job?: Job;
  constructor(
    private route: ActivatedRoute,
    private jobService: JobService,
    private location: Location
  ) { }
  ngOnInit(): void {
    this.getJob();
  }
  getJob(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.jobService.getJob(id).subscribe( job => this.job = job );
  }
  goBack(): void {
    this.location.back();
  }
}
