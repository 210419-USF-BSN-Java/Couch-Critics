import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {UserServiceService} from "../../../services/user-service.service"
import {User} from "../../../models/user"
import {Subscription} from'rxjs'
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-update-user-info',
  templateUrl: './update-user-info.component.html',
  styleUrls: ['./update-user-info.component.css']
})
export class UpdateUserInfoComponent implements OnInit {
  user!: User;
  editForm!: FormGroup;
  currentUserLoggedIn!: User; 

  @Output() btnClick: EventEmitter<User> = new EventEmitter(); 
  @Output() updateClicked = new EventEmitter<Event>(); 


  constructor(private UserServiceService: UserServiceService, private FormBuilder : FormBuilder ) {     
  }
  


  ngOnInit(): void {
    this.currentUserLoggedIn = this.UserServiceService.getCurrentUserObject(); 

      this.editForm = this.FormBuilder.group({
      userid: this.UserServiceService.getCurrentUserId(), 
      firstName:[''],
      lastName: [''],
      username: [''],
      password: [''],
      email: [''], 
      statusid: this.currentUserLoggedIn.statusid,
      roleId: this.currentUserLoggedIn.roleId,

    })
  }

  onSave(){
    this.btnClick.emit(); 
    console.log("on save called")
    console.log("user updated")
    console.log(this.editForm.value)
    this.UserServiceService.updateUser( this.editForm.value).pipe(first())
    .subscribe()
    let userid = this.UserServiceService.getCurrentUserId(); 
    this.UserServiceService.getUserById(userid)
    location.reload();
  }

  updateSiblingC(event: Event){
    this.updateClicked.emit(event)
  }

  onCancel(){
    this.btnClick.emit(); 
    console.log("on cancel called")
  }

}
