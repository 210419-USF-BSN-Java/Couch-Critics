import { Injectable } from '@angular/core';
import {user} from '../user-stories/mock-user'; 
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
  private apiUrl = "http://localhost:3000/users" //http server mocked
  //just for mocking purposes, uses json.db file, json http server to mimic pulling from actual server 
  getallUsers(): Observable <User[]>{
    return this.http.get<User[]>(this.apiUrl); 
  }

  getUserById(id: number): Observable<User[]>{
    //const aUser = of(user.filter(e => e.userId === id))
    //return aUser; 
    // static mock user file
   const array =this.http.get<User[]>(this.apiUrl)
    .pipe(map(users => users.filter(user => user.id === id))); //this filters our returned observable based on id
    console.log(array)
    return array
    //this should filter the array if a element matches the passed in paramter for that particular id,
    //filter returns a new array where condition applies 
    
  }

  updateUserById(id: Number, user: User): Observable<User> {
    const url =  `${this.apiUrl}/${id}`
    return this.http.put<User>(url, user, httpOptions); 

  }
}
