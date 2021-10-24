import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { JobDetailsComponent } from './jobdetails/job-details.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { RegisterEmployerComponent } from './register-employer/register-employer.component';
import { RegisterJobSeekerComponent } from './register-job-seeker/register-job-seeker.component';
import { ProfileComponent } from './profile/profile.component';
import { CourseComponent } from './course/course.component';
import { CourseEmployerComponent } from './course-employer/course-employer.component';
import { DashboardEmployerComponent } from './dashboard-employer/dashboard-employer.component';

const routes: Routes = [
  { path: '', redirectTo: '/landing', pathMatch: 'full' },
  { path: 'landing', component: LandingComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'dashboard-employer', component: DashboardEmployerComponent },
  { path: 'job/:id', component: JobDetailsComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register_employer', component: RegisterEmployerComponent },
  { path: 'register_job_seeker', component: RegisterJobSeekerComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'courses', component: CourseComponent },
  { path: 'course-employer', component: CourseEmployerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
