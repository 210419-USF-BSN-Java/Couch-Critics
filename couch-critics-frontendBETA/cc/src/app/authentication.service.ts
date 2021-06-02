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
    return this.http.post(`${env.BACKEND_URL}/auth`, loginInfo).pipe(
      map(response => response as User)
    );
  }
}
