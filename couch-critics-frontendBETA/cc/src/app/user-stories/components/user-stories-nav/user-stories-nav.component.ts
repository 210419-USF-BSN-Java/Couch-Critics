import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-stories-nav',
  templateUrl: './user-stories-nav.component.html',
  styleUrls: ['./user-stories-nav.component.css']
})
export class UserStoriesNavComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }
  logout() {
    sessionStorage.clear();
    this.router.navigate(['']);
    alert("you are logged off");
  }
}
