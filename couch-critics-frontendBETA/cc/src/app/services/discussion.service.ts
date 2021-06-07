import { Injectable } from '@angular/core';
import { environment as env} from '../../environments/environment';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {discussion} from "../models/discussion"

import {Observable, } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class DiscussionService {
  
    private baseUrl = env.BACKEND_URL;

  constructor(private http: HttpClient) { }

  getCommentsForReview(reviewId: number): any{
    const url = `${this.baseUrl}/disc/reviews/${reviewId}`
    return this.http.get<any>(url); 
  }

  addCommentForReview(disc: discussion ){
    const url = `${this.baseUrl}/disc/add`
    return this.http.post<discussion>(url, disc,httpOptions)
    //this endpoint from server returns a boolean based on status 

  }

}

