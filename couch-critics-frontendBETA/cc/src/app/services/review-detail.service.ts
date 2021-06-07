import { Injectable } from '@angular/core';
import {review} from '../models/review-interface';
import {REVIEWS} from '../critics-stories/reviews';
import {Observable, of} from 'rxjs';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http'; 
import { environment as env} from '../../environments/environment';
import { Movie } from '../models/movie';
import { MovieDetailService } from '../services/movie-detail.service';


@Injectable({
  providedIn: 'root'
})
export class ReviewDetailService {
  rev : review[] = [];
  reviews: review = {};
  id : number = 50;
  private reviewUrl = env.BACKEND_URL;
  

  constructor(private http: HttpClient,
              private ms : MovieDetailService,
              ) { }
              

  //get Movie Id
  getMovieId(id:number | undefined): Observable<Movie>{
    const movieId = this.ms.getM().find(m => m.id===id)!;
    return of(movieId); 
  }

  //get all reviews by critics Id
  getMyReviews(id:number | undefined) : Observable<review[]>{
    let url=`${this.reviewUrl}/review/viewByCriticId/${id}`
    return this.http.post<review[]>(url, id);
  }

  //get all reviews by critics Id and review status
  getByIdAndStatus(id:number | undefined, status:string) : Observable<review[]>{
    let url=`${this.reviewUrl}/review/viewByIdAndStatus/${id}/${status}`
    return this.http.post<review[]>(url, [id,status]);
  }

  //Send newly created review to the database
  addReview(newReview : Object){
    let url = `${this.reviewUrl}/review/addReview`;
    this.http.post(url, newReview);
    // , {observe:'response'}
  }

  //Get all reviews
  getR(id:number):Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByCriticId/${id}`;
    return this.http.get<review[]>(url);
  }

  //get all pending
  getPendingStatus() : Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByReviewStatus/Pending`;
    return this.http.get<review[]>(url);
  }

  //get all accepted
  getAcceptedStatus(){
    let url = `${this.reviewUrl}/review/viewByReviewStatus/Approved`;
    return this.http.get<review[]>(url);
  }


  //denies review
  rejectReview(reviewId : number) : Observable<void> {
    return this.http.get<void>(`${this.reviewUrl}/review/decision/${reviewId}/Denied`)
  }

  //acceptReview (update from pending to accepted)
  approveReview(reviewId : number) : Observable<void> {
    return this.http.get<void>(`${this.reviewUrl}/review/decision/${reviewId}/Approved`);
  }
}
