import { Component, OnInit, Input } from '@angular/core';
import { JobSeeker } from '../jobseeker';

@Component({
  selector: 'app-jobseeker',
  templateUrl: './jobseeker.component.html',
  styleUrls: ['./jobseeker.component.css']
})
export class JobSeekerComponent implements OnInit {
  @Input() jobseeker?: JobSeeker;

  constructor() { }

  ngOnInit() {
  }

}
