import { Component, OnInit } from '@angular/core';
import { review } from 'src/app/models/review-interface';
import { ReviewDetailService } from 'src/app/services/review-detail.service';
import { Location } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-view-approved-reviews',
  templateUrl: './view-approved-reviews.component.html',
  styleUrls: ['./view-approved-reviews.component.css']
})
export class ViewApprovedReviewsComponent implements OnInit {

  reviews: review[] = [];

  constructor(private reviewService : ReviewDetailService, private location : Location) { }

  ngOnInit(): void {
    this.viewAllApprovedReviews(); 
  }

  viewAllApprovedReviews() : void {
    this.reviewService.getAcceptedStatus().subscribe(
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

  goBack(): void {
    this.location.back();
  }

}
