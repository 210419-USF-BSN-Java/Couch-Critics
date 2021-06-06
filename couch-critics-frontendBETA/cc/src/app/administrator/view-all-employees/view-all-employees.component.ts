import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserServiceService} from 'src/app/services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-all-employees',
  templateUrl: './view-all-employees.component.html',
  styleUrls: ['./view-all-employees.component.css']
})
export class ViewAllEmployeesComponent implements OnInit {
  users: User[] = [];


  constructor(private userService : UserServiceService, private location : Location) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
/*
  viewAllEmployees() {
    this.userService.getallEmployees()
    .subscribe(users => this.users = users); 
  }

  ngOnInit(): void {
    this.viewAllEmployees();
  }

  goBack(): void {
    this.location.back();
  }
*/
}
