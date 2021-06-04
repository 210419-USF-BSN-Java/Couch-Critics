import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {
  private apiServerUrl = environment.BACKEND_URL;

  constructor(private http: HttpClient){}

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/users/all`);
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiServerUrl}/users/add`, user);
  }

  public updateAccount(ownAccount: User): Observable<User> {
    return this.http.put<User>(`${this.apiServerUrl}/users/update`, ownAccount);
  }

  public deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/users/delete/${userId}`);
  }
}

