import { Injectable } from '@angular/core';
import {Movie} from '../models/movie';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment as env} from '../../environments/environment';
import { map } from 'rxjs/operators';

// THINK OF THIS SERVICE AS YOUR DATABASE TO RETRIEVE A LIST OF MOVIE DATA

@Injectable({
  providedIn: 'root'
})
export class MovieDetailService {

  
  private base = "api.themoviedb.org/3/movie/";
  private movieId : number[] = [8363, 11635, 9718, 13, 27205, 72105, 635302, 299534, 2109, 324857];
  arr : Movie[] = [];
  o : Movie = {};
  t : Movie = {};


  constructor(private http: HttpClient) { }

  // getMovie(movie: number): Observable<Movie>{
  //   let url = `https://${this.base}${movie}${env.key}`;
  //   return this.http.get<Movie>(url);
  // }

  // getM() : Observable<Movie>[] {
  //   let array : Observable<Movie>[] = []
  //   for(let x = 0; x < this.movieId.length; x++){
  //     let url = `https://${this.base}${this.movieId[x]}${env.key}`
  //     console.log(url)
  //     array.push( this.http.get(url).pipe(map(response => response as Movie)))
      
  //   }  
  //   return array;    
  // }


  // this function will return an array of movie details
  getM() : Movie[] {
    
    for(let x = 0; x < this.movieId.length; x++){
      this.getMovies(this.movieId[x]).subscribe(
        response =>{this.arr.push(response)}
      );
    } 
    console.log(this.arr)
    return this.arr;    
  }


  getMovies(y : number) : Observable<Movie>{
      let url = `https://${this.base}${y}${env.key}`
     // console.log(this.http.get<Movie>(url))
      return this.http.get<Movie>(url);
  }

  //rubens

  getMovie() : any {
    
    for(let x = 0; x < this.movieId.length; x++){
      this.getMovies(this.movieId[x]).subscribe(
        response =>{this.arr.push(response)}
      );
    } 
    console.log(this.arr)
    return this.arr;    
  }


  getAllMovies(y : number) : any{
      let url = `https://${this.base}${y}${env.key}`
      console.log(this.http.get<any>(url))
      return this.http.get<any>(url);
  }


}


