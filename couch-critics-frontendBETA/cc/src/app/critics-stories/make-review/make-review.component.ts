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
  movie : Movie = {};
  movies : Movie[] = [];

  constructor(private ms : MovieDetailService) { }

  ngOnInit()  {
    this.getMovies();
    this.getTest();
  }


  getMovies(): void{
    this.ms.getMovies().subscribe(
      data => {this.movie = (data)}
      );
    console.log(this.movie.original_title)
  }

  getTest(): void{
   this.movies = this.ms.getM()
  }
 
  

  

}
