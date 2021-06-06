import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { review } from '../../models/review-interface';
import { ReviewDetailService } from '../../services/review-detail.service';

@Component({
  selector: 'app-critics',
  templateUrl: './critics.component.html',
  styleUrls: ['./critics.component.css']
})
export class CriticsComponent implements OnInit {
  title = "Critics Homepage";

  //making a variable out of the object made from the import of REVIEWS
  reviews: review[] = [];
  pendings: review[] = [];
  accepted: review[] = [];
  id: number = 50;
  pending: string = "pending";
  approved: string = "approved";





  constructor(private detail: ReviewDetailService) { }

  ngOnInit() {
  
  }

  //getting all critics review by id to be used on HTML
  getMyReview(): void {
    this.detail.getMyReviews(this.id).subscribe(
      response => this.reviews = (response)
    );
  }

  //getting all critics pending review by id and status to be used on HTML
  getMyPending(): void {
    this.detail.getByIdAndStatus(this.id, this.pending).subscribe(
      response => this.pendings = (response)
    )
  }

  getMyAccepted(): void {
    this.detail.getByIdAndStatus(this.id, this.approved).subscribe(
      response => this.accepted = (response)
    )
  }


  // //practicing
  // getDetail() : void{
  //   this.detail.getReview().subscribe(
  //     reviews=>this.reviews=reviews
  //     );
  // }

  // //testing
  // getTest(){
  //   this.detail.getTest().subscribe(
  //     data => {this.test = (data)}
  //   )
  // }




}