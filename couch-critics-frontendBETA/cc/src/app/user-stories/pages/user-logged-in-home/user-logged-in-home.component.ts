import { Component, OnInit } from '@angular/core';
import {MovieDetailService} from "../../../services/movie-detail.service"
import { Movie} from "../../../models/movie"

@Component({
  selector: 'app-user-logged-in-home',
  templateUrl: './user-logged-in-home.component.html',
  styleUrls: ['./user-logged-in-home.component.css']
})
export class UserLoggedInHomeComponent implements OnInit {
  title = "View Critic Reviews";
  movies: Movie[] = []; 
  movieId: Movie[] = []; 

  constructor(private ms : MovieDetailService,) { }

  ngOnInit(): void {
    this.getMovies(); 
  }

  getMovies() {
    this.movies = this.ms.getM(); 
    //console.log("init page of movies" + this.movies)
  }

}
