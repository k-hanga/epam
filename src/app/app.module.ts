import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing.component';
import { JobSeekerComponent } from './jobseeker/jobseeker.component';
import { MessagesComponent } from './messages/messages.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { JobDetailsComponent } from './jobdetails/job-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { VerifyComponent } from './verify/verify.component';
import { ProfileComponent } from './profile/profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterJobSeekerComponent } from './register-job-seeker/register-job-seeker.component';
import { RegisterEmployerComponent } from './register-employer/register-employer.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    JobSeekerComponent,
    MessagesComponent,
    DashboardComponent,
    JobDetailsComponent,
    LoginComponent,
    RegisterComponent,
    VerifyComponent,
    ProfileComponent,
    NavbarComponent,
    RegisterJobSeekerComponent,
    RegisterEmployerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
