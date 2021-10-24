import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-employer',
  templateUrl: './register-employer.component.html',
  styleUrls: ['./register-employer.component.css']
})
export class RegisterEmployerComponent implements OnInit {
  uname: string;
  isemployee : boolean;
  constructor(private userService: UserService) { }


  ngOnInit() {
  }

  creatUser(): void
  {
    const user : User =
      {
        username : this.uname,
        employee : true,
        balance : 0,
        xp:0,
        skills:[],
        contracted:false,
        id:0
      }
    this.userService.createUser(user);
  }
}
