import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { review } from '../../models/review-interface';
import { ReviewDetailService } from '../../services/review-detail.service';
import { MovieDetailService } from 'src/app/services/movie-detail.service';
import { Movie } from 'src/app/models/movie';

@Component({
  selector: 'app-review-detail',
  templateUrl: './review-detail.component.html',
  styleUrls: ['./review-detail.component.css']
})
export class ReviewDetailComponent implements OnInit {
  r: review | undefined;
  m: Movie | undefined;
  

  constructor(
    private route: ActivatedRoute,
    private detail: ReviewDetailService,
    private location: Location,
    private ms: MovieDetailService
  ) { }


  ngOnInit(): void {
    // this.getDetail()
    this.getParamMovieId()
  }
  // /// practice -------------
  //   getDetail(): void{
  //     const id = Number(this.route.snapshot.paramMap.get('id'));
  //     this.detail.getreview(id).subscribe(r => this.r = r);
  //   }
  // // -----------

  //This methods looks at your URL and grabs the Id and then create an object using that Id.. this object is then used for html
  getParamMovieId(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'))
    this.detail.getMovieId(id).subscribe(m => this.m = m);
  }

  //getting parameters and using our addreview services
  //gotta make form data

  goBack(): void {
    this.location.back();
  }



}