import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router"
import {Location} from "@angular/common"

import {review} from "../../../models/review-interface"
import {Movie} from "../../../models/movie"
import {User} from "../../../models/user"
import {UserServiceService} from "../../../services/user-service.service"
import {MovieDetailService} from '../../../services/movie-detail.service'
import {ReviewDetailService} from "../../../services/review-detail.service"
import {DiscussionService} from "../../../services/discussion.service"

@Component({
  selector: 'app-user-view-a-movie',
  templateUrl: './user-view-a-movie.component.html',
  styleUrls: ['./user-view-a-movie.component.css']
})
export class UserViewAMovieComponent implements OnInit {
  r: review | undefined;
  m!: Movie; 
  u: User | undefined; 
  currentPageMovieId: any; 
  currentPageMovieName: any | undefined; 
  c: any | undefined;
  userComments: any | undefined;
  currentReview: any | undefined;

  constructor(
    private route: ActivatedRoute,
    private reviewDetail: ReviewDetailService,
    private location: Location, 
    private movieDetail: MovieDetailService, 
    private disc: DiscussionService
  ) { }

  ngOnInit(): void {
    this.getParamMovieId(); 
   // this.getReviewDetails()
  }
  getParamMovieId(): void{
    const id = Number(this.route.snapshot.paramMap.get('id'))
    this.currentPageMovieId = id;
    console.log("current page id " + this.currentPageMovieId)
    this.reviewDetail.getMovieId(id).subscribe(m => this.m =m);
    console.log(this.m)
    this.currentPageMovieName = this.m.original_title;
    console.log(this.currentPageMovieName)
    this.getReviewDetails(this.currentPageMovieName); 
  }
  

  getReviewDetails(MovieName: any){
   this.reviewDetail.getReviewByMovieName(MovieName).subscribe( r => {
     //console.log(r)
     let x : any  = r;
     this.c = x; 
     let reviewid: any = x[0].reviewId;
     this.currentReview = reviewid; 
     console.log("this is the current review id " + this.currentReview)
     //console.log("current global var " + this.c)

    // console.log(x)
     this.getReviewComments(this.currentReview); 
     return
   })
  }

  getReviewComments(reviewId: any){
    this.disc.getCommentsForReview(reviewId).subscribe( (c: any) => {
      console.log(c)
      let comments: any = c; 
      this.userComments = comments; 
      console.log(comments)
      console.log("array of comments" + this.userComments)
      console.log("this is the returned array of comments for this review "+ comments)
    })
  }

  goBack(){
    this.location.back()
  }

}
