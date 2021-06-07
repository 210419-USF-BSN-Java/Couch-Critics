import { Component, OnInit } from '@angular/core';
import { review } from 'src/app/models/review-interface';
import { ReviewDetailService } from 'src/app/services/review-detail.service';
import { Location } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-view-pending-reviews',
  templateUrl: './view-pending-reviews.component.html',
  styleUrls: ['./view-pending-reviews.component.css']
})
export class ViewPendingReviewsComponent implements OnInit {

  reviews: review[] = [];

  constructor(private reviewService : ReviewDetailService, private location : Location) {}

  viewAllPendingReviews() : void {
    this.reviewService.getPendingStatus().subscribe(
      (response: review[]) => {
        this.reviews = response;
        console.log(this.reviews);
        console.log(response[0].reviewId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  rejectReview (reviewId : number) : void {
    this.reviewService.rejectReview(reviewId).subscribe(
      (response: void) => {
        console.log(response);
        this.viewAllPendingReviews();
      },
      (error : HttpErrorResponse) => {
        console.log(error.message);
      }
    ); 
  }

  approveReview (reviewId : number) : void {
    this.reviewService.approveReview(reviewId).subscribe(
      (response: void) => {
        console.log(response);
        this.viewAllPendingReviews();
      },
      (error : HttpErrorResponse) => {
        console.log(error.message);
      }
    ); 
  }

  ngOnInit(): void {
    this.viewAllPendingReviews();
  }

  goBack(): void {
    this.location.back();
  }

}
