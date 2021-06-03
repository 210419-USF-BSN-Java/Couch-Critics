import { Injectable } from '@angular/core';
import {user} from '../user-stories/mock-user'; 
import { User} from '../models/user';
import {Observable, of } from 'rxjs'

const userId = 1; 
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  static getUserById(arg0: number): User | undefined {
    throw new Error('Method not implemented.');
  }

  constructor() { }
  //just for mocking purposes 
  getallUsers(): Observable <User[]>{
    const users = of(user)
    return users; 
  }

  getUserById(id: number): Observable<User[]>{
    const aUser = of(user.filter(e => e.userId === id))
    //this should filter the array if a element matches the passed in paramter for that particular id,
    //filter returns a new array where condition applies 
    return aUser; 
  }
}
