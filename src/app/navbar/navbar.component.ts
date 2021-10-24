import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public loggedin: boolean;
  constructor(private app: AppComponent) { }

  ngOnInit() {
    console.error(sessionStorage.getItem('userId'));
  }

  isLoggedIn(): boolean {
    return sessionStorage.getItem('userId') === null;
  }
}
