import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router'; 
import { LogOutService } from 'src/app/services/log-out.service';
import { Location } from '@angular/common';
@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent implements OnInit {

  viewEmployees() {
  this.router.navigate(['view-employees']);
  }

  viewUsers() {
    this.router.navigate(['view-users']);
  }

  viewApprovedReviews() {
    this.router.navigate(['view-approved-reviews']);
  }

  viewPendingReviews() {
    this.router.navigate(['view-pending-reviews']);
  }

  logOff() {
    this.logoff.logout
  }

  goBack(): void {
    this.location.back();
  }

  constructor(private router : Router, private logoff : LogOutService, private location : Location) { }

  ngOnInit(): void {
  }



}
