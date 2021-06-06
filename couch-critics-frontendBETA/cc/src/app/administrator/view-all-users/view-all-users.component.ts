import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserServiceService} from 'src/app/services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-all-users',
  templateUrl: './view-all-users.component.html',
  styleUrls: ['./view-all-users.component.css']
})
export class ViewAllUsersComponent implements OnInit {
  users : User[] = [];

  constructor(private userService : UserServiceService, private location : Location) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
/*
  viewAllUsers() : void {
    this.userService.getallUsers()
    .subscribe(users => this.users = users);
  }

  ngOnInit(): void {
    this.viewAllUsers();
  }

  goBack(): void {
    this.location.back();
  }
*/
}
