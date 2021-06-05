import { JsonpClientBackend } from '@angular/common/http';
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
        console.log(response)

        let userId = response.userid; 
        //this works, sets as json format in sessionstorage
        //session storage gets deleted automatically when exiting specific tab initially logged in,closing browser
        window.sessionStorage.setItem('currentUserid', JSON.stringify(userId));
        window.sessionStorage.setItem('currentUserObject', JSON.stringify(response));

        let userType = response.roleId?.roleId;

        switch(userType) {
          //If the role id of the account is one, this takes the user to the admin pages
          case 1:
            this.router.navigate(['admin']);
            break;

          //If the role id of the account is two, this takes the user to the critics page
          case 2:
             this.router.navigate(['critics']);
             break;
      
          //If the role id of the account is three, this takes the user to the user page
          case 3:
            this.router.navigate(['userhome']);
            break;

          //If there is no role id, an alert pops up on screen and the user is taken back to the login page  
          default:
            alert("Something went wrong!");
            this.router.navigate(['']);
        }
       
      },
      // If this pops up on the console, that means some kind of Http Communication error happend
      err =>{
        console.log('In error block! err ' + err);
      },

      // If this pops up on the console, that means the Http Communication between Angular and Spring was successful
      () => {
        console.log(('Observable is complete'));
      }
    )
  }
}
