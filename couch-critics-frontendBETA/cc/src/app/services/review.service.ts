import { Injectable } from '@angular/core';
import { Review } from '../models/review';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor() { }

  /** GET reviews from the server 
   *   private heroesUrl = 'api/heroes';  // URL to web api
   *   getHeroes(): Observable<Hero[]> {
    return this.http.get<Hero[]>(this.heroesUrl)
      .pipe(
        tap(_ => this.log('fetched heroes')),
        catchError(this.handleError<Hero[]>('getHeroes', []))
      );
  } */
}
