import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User} from '../../../models/user'
import {UserServiceService} from "../../../services/user-service.service"


@Component({
  selector: 'app-user-account-info',
  templateUrl: './user-account-info.component.html',
  styleUrls: ['./user-account-info.component.css']
})

export class UserAccountInfoComponent implements OnInit {
  @Output() btnClick = new EventEmitter(); 
  currentUser!: User; //this just pastes the mock data for the user into this component, will refactor to use service instead
 //this just pastes the mock data for the user into this component, will refactor to use service instead
  constructor(private UserServiceService: UserServiceService) { 
    this.currentUser;
    //this output an initial error because currentUser is defined
    //if current user is undefined, then render no user
  }

  ngOnInit(): void {
    let id = this.UserServiceService.getCurrentUserId(); 
    if(!id){
      console.log("no user logged in")
    }
    this.UserServiceService.getUserById(id).subscribe((user) => {
      this.currentUser = user
    });  
  }
  showEditForm(){
    this.btnClick.emit(); 
    console.log("edit form show button clicked")
    
  }

  updateInformation(){
    this.UserServiceService.getUserById(1).subscribe((user) => {
      console.log(user)
      this.currentUser = user
    })
  }

}
