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

  // //Get all reviews
  // getR(id:number):Observable<review[]>{
  //   let url = `${this.reviewUrl}/review/viewByCriticId/${id}`;
  //   return this.http.get<review[]>(url);
  // }

  //get Movie Id
  getMovieId(id:number): Observable<Movie>{
    const movieId = this.ms.getM().find(m => m.id===id)!;
    return of(movieId); 
  }

  // //get Pending Status
  // getPendingStatus() : Observable<review[]>{
  //   let url = `${this.reviewUrl}/review/viewByReviewStatus/Pending`;
  //   return this.http.get<review[]>(url);
  // }

  // //get all accepted
  // getAcceptedStatus(){
  //   let url = `${this.reviewUrl}/review/viewByReviewStatus/accepted`;
  //   return this.http.get<review[]>(url);
  // }

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
  addReview(newReview : Object) : void{
    let url = `${this.reviewUrl}/review/addReview`;
    this.http.post<Object>(url, newReview);
    // , {observe:'response'}
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

  
  /// Error returning is skipped for now

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

  setReviewId(id: number){
    let a = {reviewId: id}
    a.reviewId = id; 
    window.sessionStorage.setItem("currentreviewid", JSON.stringify(a)); 
  }

  getCurrentReviewId(){
    let id = JSON.parse(window.sessionStorage.getItem('currentreviewid')!); 
    console.log("currentuserid is " + id)
    
    return id; 
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
