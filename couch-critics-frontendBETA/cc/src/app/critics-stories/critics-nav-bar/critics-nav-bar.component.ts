import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-critics-nav-bar',
  templateUrl: './critics-nav-bar.component.html',
  styleUrls: ['./critics-nav-bar.component.css']
})
export class CriticsNavBarComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }


  logout() {
    sessionStorage.clear();
    this.router.navigate(['']);
    alert("you are logged off");
  }

  home(){
    this.router.navigate(['/create'])
  }

  makeReview(){
    this.router.navigate(['/critics'])
  }
}
