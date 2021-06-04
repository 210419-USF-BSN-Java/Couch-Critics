import { Injectable } from '@angular/core';
import {review} from '../models/review-interface';
import {REVIEWS} from '../critics-stories/reviews';
import {Observable, of} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReviewDetailService {

  private reviewUrl = '/review';

  constructor(private http: HttpClient) { }

  getReview(): Observable<review[]>{
    const reviews = of(REVIEWS)
    return reviews;
  }

  getreview(id:number): Observable<review>{
    const review = REVIEWS.find(h=>h.movieId===id)!;
    return of(review);
  }


  /// functions below are attempting to retrieve observables from our server
  /// Error returning is skipped for now
  getR():Observable<review[]>{
    return this.http.get<review[]>(this.reviewUrl)
  }

  getPendingStatus(p:String){
    let url = `${this.reviewUrl}/viewByReviewStatus/{p}`;
    return this.http.get<review>(url);
  }

  getAcceptedStatus(a:String){
    let url = `${this.reviewUrl}/viewByReviewStatus/{a}`;
    return this.http.get<review>(url);
  }

}
