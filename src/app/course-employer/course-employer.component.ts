import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseemployerService } from '../courseemployer.service';

@Component({
  selector: 'app-course-employer',
  templateUrl: './course-employer.component.html',
  styleUrls: ['./course-employer.component.css']
})
export class CourseEmployerComponent implements OnInit {
  courses: Course[] = [];
  constructor(private courseService: CourseemployerService) {}
  ngOnInit() {
    this.getCourses();
  }
  getCourses(): void {
    this.courseService.getCourses().subscribe(courses => this.courses = courses.slice(0, 20));
  }
}
