import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { map } from 'rxjs/operators';
import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  //Change to env.H2_TEST to access H2-CONSOLE URL
  //Change to env.BACKEND_URL if you need to access backend
  private apiServerUrl = env.BACKEND_URL;


  login(username:string, password:string): Observable<User>{

    const params = new HttpParams()
    .set('uName', username)
    .set('pWord', password);

    // let loginInfo = {
    //   uName : username,
    //   pWord : password
    // }


    // return this.http.post(`${this.apiServerUrl}/users/login`, loginInfo).pipe(
    //   map(response => response as User)
    // );

    return this.http.post(`${this.apiServerUrl}/users/login`, params).pipe(map(response => response as User));
  }
}
