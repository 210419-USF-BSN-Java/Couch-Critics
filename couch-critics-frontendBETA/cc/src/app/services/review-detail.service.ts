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

  // //getting Observable of movies from our movie detail service(movie database feteched from API)
  // getMovies(): Observable<Movie[]>{
  //   const movie = of(this.ms.getM())
  //   return movie;
  // }

  /// functions below are attempting to retrieve observables from our server
  /// Error returning is skipped for now

  //Get all reviews
  getR(id:number):Observable<review[]>{
    let url = `${this.reviewUrl}/viewByCriticId/${id}`;
    return this.http.get<review[]>(url);
  }

  //get all pending
  getPendingStatus(p:String){
    let url = `${this.reviewUrl}/viewByReviewStatus/{p}`;
    return this.http.get<review>(url);
  }

  //get all accepted
  getAcceptedStatus(a:String){
    let url = `${this.reviewUrl}/viewByReviewStatus/accepted`;
    return this.http.get<review>(url);
  }

  //just testing
  getTest():Observable<Object>{
    return this.http.get('https://api.themoviedb.org/3/movie/550?api_key=dd454d7a4e6f0047a483673b42f31898');
  }
}
