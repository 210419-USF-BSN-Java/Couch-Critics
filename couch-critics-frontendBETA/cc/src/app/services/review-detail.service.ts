import { Injectable } from '@angular/core';
import {review} from '../models/review-interface';
import {REVIEWS} from '../critics-stories/reviews';
import {Observable, of} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { environment as env} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReviewDetailService {
  rev : review[] = [];
  reviews: review[] = [];
  private reviewUrl = env.BACKEND_URL;
  private testUrl = "https://api.themoviedb.org/3/movie/550?api_key=dd454d7a4e6f0047a483673b42f31898";

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

  //Get all reviews
  getR(id:number):Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByCriticId/${id}`;
    return this.http.get<review[]>(url);
  }

  //get all pending
  getPendingStatus() : Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByReviewStatus/Pending`;
    console.log(this.http.get<review[]>(url).subscribe(reviews => this.reviews = reviews));
    return this.http.get<review[]>(url);
  }

  //get all accepted
  getAcceptedStatus(){
    let url = `${this.reviewUrl}/review/viewByReviewStatus/accepted`;
    return this.http.get<review[]>(url);
  }

  //just testing
  getTest():Observable<Object>{
    return this.http.get('https://api.themoviedb.org/3/movie/550?api_key=dd454d7a4e6f0047a483673b42f31898');
  }
}
