import { Component, OnInit } from '@angular/core';
import { MovieDetailService} from '../../services/movie-detail.service';
import { Movie } from '../../models/movie';



@Component({
  selector: 'app-make-review',
  templateUrl: './make-review.component.html',
  styleUrls: ['./make-review.component.css']
})

export class MakeReviewComponent implements OnInit {
  title = "Create Movie Review";
  movies : Movie[] = [];
  movieId : Movie[] =[];

  constructor(private ms : MovieDetailService,) { }

  ngOnInit()  {
    this.getMovies();
  }

  //getting movie data from our movie services
  getMovies(): void{
   this.movies = this.ms.getM()
  }

  // movingMovieId() : void{
  //  this.rs.getMovies().subscribe(
  //   movies => (this.movieId=movies)
  //  );
  // }
  

}
