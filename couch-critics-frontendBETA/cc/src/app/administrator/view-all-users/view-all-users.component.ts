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


  viewAllUsers() : void {
    this.userService.getUsers().subscribe(
      (response : User[]) => {
        this.users = response;
        console.log(this.users);
        console.log(response[0].userid);
      }
    )
  }

  banUser() : void {}

  ngOnInit(): void {
    this.viewAllUsers();
  }

  goBack(): void {
    this.location.back();
  }

}
