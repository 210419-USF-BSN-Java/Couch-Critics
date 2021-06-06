import { Component, OnInit } from '@angular/core';
import { review } from 'src/app/models/review-interface';
import { ReviewDetailService } from 'src/app/services/review-detail.service';
import { Location } from '@angular/common';

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
    this.reviewService.getAcceptedStatus()
    .subscribe(reviews => this.reviews = reviews);
  }

  goBack(): void {
    this.location.back();
  }

}
