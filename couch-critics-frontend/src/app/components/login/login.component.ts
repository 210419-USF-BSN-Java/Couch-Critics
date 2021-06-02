import { Component, OnInit } from '@angular/core';
import { Router, Routes} from '@angular/router'; 
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from 'src/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  username : string = '';
  password : string = '';

  constructor(private authServ : AuthenticationService, private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.authServ.login(this.username, this.password).subscribe(
      response => {
        this.router.navigate(['dashboard']);
      },
      err => {
        console.log('In error block! err: ' + err);
      },
      () => {
        console.log("Observable is complete"); 
      }
      
    )
  }

}
