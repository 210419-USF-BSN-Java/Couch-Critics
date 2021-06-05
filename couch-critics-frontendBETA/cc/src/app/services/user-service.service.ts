import { Injectable } from '@angular/core';
import { User} from '../models/user';
import {Observable, of, pipe } from 'rxjs';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import { filter, map } from 'rxjs/operators';

const userId = 1; 
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  constructor(private http: HttpClient) { }
  private apiUrl = "http://localhost:8080/users";
  users : User[] = [];

  getallEmployees(): Observable <User[]>{
    return this.http.get<User[]>(`${this.apiUrl}/getUsers/employee`);
  }

  getallUsers(): Observable <User[]>{
    return this.http.get<User[]>(`${this.apiUrl}/getUsers/customer`);
  }

  getUserById(id: number): Observable<User[]>{
    //const aUser = of(user.filter(e => e.userId === id))
    //return aUser; 
    // static mock user file
    const array =this.http.get<User[]>(this.apiUrl)
    .pipe(map(users => users.filter(user => user.userid === id))); //this filters our returned observable based on id
    console.log(array)
    return array
    //this should filter the array if a element matches the passed in paramter for that particular id,
    //filter returns a new array where condition applies 
    
  }

  updateUserById(id: Number, user: User): Observable<User> {
    const url =  `${this.apiUrl}/${id}`
    return this.http.put<User>(url, user, httpOptions); 
  }

  //updateUser(user: User): Observable<User> {
    //const url = `${this.apiUrl}/update`
  //}

  getCurrentUserId(){
    let id = window.sessionStorage.getItem('currentUserid'); 
    console.log(id)
    return id; 
  }

  getCurrentUserObject(){
    let userObject = window.sessionStorage.getItem('currentUserObject'); 
    console.log(userObject)
    return userObject;
  }
}
