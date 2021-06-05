import { Injectable } from '@angular/core';
import { User} from '../models/user';
import {Observable, of, pipe } from 'rxjs';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import { catchError, filter, map, tap } from 'rxjs/operators';
import { environment as env } from 'src/environments/environment';


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

  private apiServerUrl = env.BACKEND_URL;
  /*
  getallUsers(): Observable <User[]>{
    return this.http.get<User[]>(`${this.apiServerUrl}/users`); //
  }
  */
//changed backend mapping to get for the sake of having a demo
  getUserById(id: any): Observable<User>{
    
    return this.http.get<User>
    (`${this.apiServerUrl}/users/getUsersById/${id}`).pipe(map(users => users))  
    
  }

  updateUser(user: User): Observable<User>{
    const url = `${this.apiServerUrl}/users/update`
    return this.http.post<User>(url, user, httpOptions); 
  }

  getCurrentUserId(){
    let id = window.sessionStorage.getItem('currentUserid'); 
    console.log("currentuserid is " + id)
    
    return id; 
  }

  getCurrentUserObject(){
    let userObject = window.sessionStorage.getItem('currentUserObject'); 
    console.log("current userObject from session storage is " + userObject)
    return userObject;
  }
}
