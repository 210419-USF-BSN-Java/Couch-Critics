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
  m: Movie = {};
  newReview : review ={};
  x: number | undefined;
  

  constructor(
    private route: ActivatedRoute,
    private detail: ReviewDetailService,
    private location: Location,
    private ms: MovieDetailService
  ) { }


  ngOnInit(): void {
    // this.getDetail()
    this.getParamMovieId()
    this.test()
    
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
    console.log(this.m?.id)
  }

  //getting parameters and using our add review services
  makeReview(mId : number | undefined, name:string |undefined, review : string, authorId : number) : void{
    this.newReview = {movieId : mId, movieName : name, review, authorId}
    this.detail.addReview(this.newReview);
  }

  make(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.detail.getMovieId(id).subscribe(m => this.m = m);
    let name : string | undefined = this.m.original_title;
    this.x  = this.m.id;
    let r : string | undefined = "What up suckas";
    let a : number = 53;
    this.makeReview(this.x,name,r,a);
    console.log(this.x)
    console.log(name)
    
  }

  test(){
    let r : review = {movieId: 13, movieName: "wtf LOL", review:"just testing"}
    this.detail.addReview(r);
    console.log(r)
  }

  goBack(): void {
    this.location.back();
  }



}