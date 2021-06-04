import { Component, OnInit } from '@angular/core';
import {user} from '../../mock-user' //this is for ui rendering purposes
import { User} from '../../../models/user'
import {UserServiceService} from "../../../services/user-service.service"


@Component({
  selector: 'app-user-account-info',
  templateUrl: './user-account-info.component.html',
  styleUrls: ['./user-account-info.component.css']
})
export class UserAccountInfoComponent implements OnInit {
  currentUser!: User[]; //this just pastes the mock data for the user into this component, will refactor to use service instead
 //this just pastes the mock data for the user into this component, will refactor to use service instead
  constructor(private UserServiceService: UserServiceService) { 
  
  }

  ngOnInit(): void {
    this.UserServiceService.getUserById(1).subscribe(user => this.currentUser = user);  //issue
  }

}
