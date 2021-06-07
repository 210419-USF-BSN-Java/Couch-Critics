import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserServiceService} from 'src/app/services/user-service.service';
import { Location } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { CriticsNavBarComponent } from 'src/app/critics-stories/critics-nav-bar/critics-nav-bar.component';

@Component({
  selector: 'app-view-all-users',
  templateUrl: './view-all-users.component.html',
  styleUrls: ['./view-all-users.component.css']
})
export class ViewAllUsersComponent implements OnInit {
  users : User[] = [];

  constructor(private userService : UserServiceService, private location : Location) { }


  viewAllUsers() : void {
    this.userService.getUsers().subscribe(
      (response : User[]) => {
        this.users = response;
        console.log(this.users);
        console.log(response[0].userid);
      }
    )
  }

  banUser(reviewId : number) : void {
    this.userService.banUser(reviewId).subscribe(
      (response: void) => {
        console.log(response);
        this.viewAllUsers();
      },
      (error : HttpErrorResponse) => {
        console.log(error.message);
      }
    ); 
  }

  activateUser(reviewId : number) : void {
    this.userService.activateUser(reviewId).subscribe(
      (response: void) => {
        console.log(response);
        this.viewAllUsers();
      },
      (error : HttpErrorResponse) => {
        console.log(error.message);
      }
    ); 
  }

  ngOnInit(): void {
    this.viewAllUsers();
  }

  goBack(): void {
    this.location.back();
  }

}
