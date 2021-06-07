import { Injectable } from '@angular/core';
import {review} from '../models/review-interface';
import {REVIEWS} from '../critics-stories/reviews';
import {Observable, of} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { environment as env} from '../../environments/environment';
import { Movie } from '../models/movie';
import { MovieDetailService } from '../services/movie-detail.service';

@Injectable({
  providedIn: 'root'
})
export class ReviewDetailService {
  rev : review[] = [];
  reviews: review[] = [];
  private reviewUrl = env.BACKEND_URL;
  private testUrl = "https://api.themoviedb.org/3/movie/550?api_key=dd454d7a4e6f0047a483673b42f31898";

  constructor(private http: HttpClient,
              private ms : MovieDetailService,
              ) { }
              
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
  getMovieId(id:number): Observable<Movie>{
    const movieId = this.ms.getM().find(m => m.id===id)!;
    return of(movieId); 
  }

  //Ruben
  /*
   getMovieIdAny(id:number): any{
    const movieId = this.ms.getMovie().find((m: { id: number; }) => m.id===id)!;
    console.log("movie of specific page is " + of(movieId))
    return of(movieId); 
  }
  */
  //Ruben

  // //getting Observable of movies from our movie detail service(movie database feteched from API)
  // getMovies(): Observable<Movie[]>{
  //   const movie = of(this.ms.getM())
  //   return movie;
  // }

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
  //this method will return us an array of all Critic reviews for a specific movie in our 
  //database, caseSensitive, 
  //need to redo for future because movie names are not unique and characters vary by language
  //MovieName passed in needs to be movie name from our database

  getReviewByMovieName(MovieName: any){
    let url = `${this.reviewUrl}/review/viewByMovieName/${MovieName}`
    //only getting first result from return array 
    return this.http.get<any>(url); 
  }

}
