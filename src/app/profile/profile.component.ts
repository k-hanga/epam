import {Component, Input, OnInit} from '@angular/core';
import { Location } from '@angular/common';
import {JobSeekerService} from '../job-seeker.service';
import {JobSeeker} from '../job-seeker';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() jobSeeker?: JobSeeker;
  constructor(
    private jobSeekerService: JobSeekerService,
    private location: Location
  ) { }

  ngOnInit() {
  }
  save(): void {
    if (this.jobSeeker) {
      this.jobSeekerService.updateJobSeeker(this.jobSeeker)
        .subscribe(() => this.goBack());
    }
  }
  goBack(): void {
    this.location.back();
  }
}
