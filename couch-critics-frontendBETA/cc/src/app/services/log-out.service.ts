import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LogOutService {

  logout() {
    sessionStorage.clear();
    this.router.navigate(['']);
    alert("you are logged off");
  }

  constructor(private router : Router) { }
}
