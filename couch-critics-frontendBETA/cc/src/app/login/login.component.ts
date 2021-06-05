import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

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
        let userType = response.roleId?.roleId;

        switch(userType) {
          case 1:
            this.router.navigate(['admin']);
            break;

          case 2:
             this.router.navigate(['critics']);
             break;
      
          case 3:
            this.router.navigate(['userhome']);
            break;
          default:
            alert("Something went wrong!");
            this.router.navigate(['']);
        }
       
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
