import { Component, OnInit } from '@angular/core';
import { review } from 'src/app/models/review-interface';
import { ReviewDetailService } from 'src/app/services/review-detail.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-pending-reviews',
  templateUrl: './view-pending-reviews.component.html',
  styleUrls: ['./view-pending-reviews.component.css']
})
export class ViewPendingReviewsComponent implements OnInit {

  reviews: review[] = [];

  constructor(private reviewService : ReviewDetailService, private location : Location) { }

  viewAllPendingReviews() : void {
    this.reviewService.getPendingStatus()
    .subscribe(reviews => this.reviews = reviews);
  }

  ngOnInit(): void {
    this.viewAllPendingReviews();
  }

  goBack(): void {
    this.location.back();
  }

}
