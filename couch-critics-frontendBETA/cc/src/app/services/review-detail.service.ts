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
              
 /// functions below are attempting to retrieve observables from our server

  //Get all reviews
  getR(id:number):Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByCriticId/${id}`;
    return this.http.get<review[]>(url);
  }

  //get Movie Id
  getMovieId(id:number): Observable<Movie>{
    const movieId = this.ms.getM().find(m => m.id===id)!;
    return of(movieId); 
  }

  //get Pending Status
  getPendingStatus() : Observable<review[]>{
    let url = `${this.reviewUrl}/review/viewByReviewStatus/Pending`;
    return this.http.get<review[]>(url);
  }

  //get all accepted
  getAcceptedStatus(){
    let url = `${this.reviewUrl}/review/viewByReviewStatus/accepted`;
    return this.http.get<review[]>(url);
  }

  //get all reviews by critics Id
  getMyReviews(id:number) : Observable<review[]>{
    let url=`${this.reviewUrl}/review/viewByCriticId/${id}`
    return this.http.post<review[]>(url, id);
  }

  //get all reviews by critics Id and review status
  getByIdAndStatus(id:number, status:string) : Observable<review[]>{
    let url=`${this.reviewUrl}/review/viewByIdAndStatus/${id}/${status}`
    return this.http.post<review[]>(url, [id,status]);
  }

  //Send newly created review to the database
  addReview(newReview : review){
    let url = `${this.reviewUrl}/review/addReview`;
    this.http.post(url, newReview), {observe:'response'};
  }
  
   // MOCK DATA STUFF
  // getReview(): Observable<review[]>{
  //   const reviews = of(REVIEWS)
  //   return reviews;
  // }

  // // how to return the observable of id for mock database
  // getreview(id:number): Observable<review>{
  //   const review = REVIEWS.find(h=>h.movieId===id)!;
  
  //   return of(review);
  // }

  // getting Observable of movie ids from our movie details service


  // //getting Observable of movies from our movie detail service(movie database feteched from API)
  // getMovies(): Observable<Movie[]>{
  //   const movie = of(this.ms.getM())
  //   return movie;
  // }

  
  /// Error returning is skipped for now
}
