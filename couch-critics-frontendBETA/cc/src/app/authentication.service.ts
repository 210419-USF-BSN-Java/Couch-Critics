import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../app/models/user';
import { environment as env } from '../environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }


  login(username:string, password:string): Observable<User>{
    let loginInfo = {
      username : username,
      password : password
    }


    //We are currently testing against the H2-CONSOLE URL
    //Change to BACKEND_URL if you need to access backend
    return this.http.post(`${env.TEST_H2_URL}/auth`, loginInfo).pipe(
      map(response => response as User)
    );
  }
}
