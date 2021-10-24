import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-navbar-anon',
  templateUrl: './navbar-anon.component.html',
  styleUrls: ['./navbar-anon.component.css']
})
export class NavbarAnonComponent implements OnInit {

  constructor(private app: AppComponent) { }

  ngOnInit() {
    //console.error(localStorage.getItem('userId'));
  }

}
