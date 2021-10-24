import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-navbar-user',
  templateUrl: './navbar-user.component.html',
  styleUrls: ['./navbar-user.component.css']
})
export class NavbarUserComponent implements OnInit {

  constructor(private app: AppComponent) { }

  ngOnInit() {
  }

  signOut(): void {
    sessionStorage.removeItem('userId');
  }


}
