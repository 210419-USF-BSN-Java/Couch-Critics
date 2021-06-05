import { Injectable } from '@angular/core';
import {Movie} from '../models/movie';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment as env} from '../../environments/environment';
import { map } from 'rxjs/operators';


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

  getM() : Movie[] {
    
    for(let x = 0; x < this.movieId.length; x++){
      this.getMoviesTest(this.movieId[x]).subscribe(
        response =>{this.o = response}
      );
      console.log(this.o.poster_path)
      console.log(this.t.original_title)
      this.arr.push(this.o)
      console.log(this.arr)
      console.log(this.arr[5])
    }  
    return this.arr;    
  }

  getMoviesTest(y : number) : Observable<Movie>{
    let url = `https://${this.base}${y}${env.key}`
    return this.http.get(url).pipe(map(response=>response as Movie));
}

  getMovies() : Observable<Movie>{
      let url = `https://${this.base}${this.movieId}${env.key}`
      this.http.get<Movie>(url).subscribe(
        response =>{this.t = response}
      );
      // console.log(this.t.id)
      return this.http.get<Movie>(url);
  }
  

}


