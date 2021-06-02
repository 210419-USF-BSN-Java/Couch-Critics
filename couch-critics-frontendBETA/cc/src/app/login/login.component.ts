import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService} from 'src/app/authentication.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private authServ : AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    //This uses the authentication method in our authentication.service
    this.authServ.login(this.username, this.password).subscribe(
      response =>{
        console.log(response);
        this.router.navigate(['dashboard']);
      },
      err =>{
        console.log('In error block! err ' + err);
      },
      () => {
        console.log(('Observable is complete'));
      }
    )
  }
}
