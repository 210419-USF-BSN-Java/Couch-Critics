import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {UserServiceService} from "../../../services/user-service.service"
import {User} from "../../../models/user"

@Component({
  selector: 'app-update-user-info',
  templateUrl: './update-user-info.component.html',
  styleUrls: ['./update-user-info.component.css']
})
export class UpdateUserInfoComponent implements OnInit {

  @Output() btnClick: EventEmitter<User> = new EventEmitter(); 
  firstName: string; 
  lastName: string; 
  username: string; 
  password: string; 
  email: string; 

  constructor(private UserServiceService: UserServiceService) { 
    this.firstName = ''
    this.lastName = ''
    this.username = ''
    this.password = ''
    this.email = ''
  }

  ngOnInit(): void {
  }

  onSave(){
    this.btnClick.emit(); 
    console.log("on save called")
    if(!this.firstName || this.lastName || this.username || this.email || this.password){
      alert('please fill all fields of the form')
      return 
    }{
      console.log("user updated")
    }
  }

  onCancel(){
    this.btnClick.emit(); 
    console.log("on cancel called")
  }

}
