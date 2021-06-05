import { Injectable } from '@angular/core';
import {Movie} from '../models/movie';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MovieDetailService {

  private key = "?api_key=dd454d7a4e6f0047a483673b42f31898";  
  private base = "api.themoviedb.org/3/movie/";
  private movieId : number[] = [8363, 11635, 9718, 13, 27205, 72105, 635302, 299534, 2109, 324857];

  constructor(private http: HttpClient) { }

  getMovie(): Observable<Movie[]>{
    let url = `${this.base}${this.movieId}${this.key}`;
    return this.http.get<Movie[]>(url);
  }

}


