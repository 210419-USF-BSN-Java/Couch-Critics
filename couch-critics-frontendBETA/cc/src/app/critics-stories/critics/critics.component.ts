import { Component, OnInit } from '@angular/core';
import { review } from '../../models/review-interface';
import { ReviewDetailService } from '../../services/review-detail.service';
import { User } from 'src/app/models/user';
import { UserServiceService } from 'src/app/services/user-service.service';


@Component({
  selector: 'app-critics',
  templateUrl: './critics.component.html',
  styleUrls: ['./critics.component.css']
})
export class CriticsComponent implements OnInit {
  panelOpenState = false;
 
  reviews: review[] = [];
  pendings: review[] = [];
  accepted: review[] = [];
  id: number | undefined = 0;
  pending: string = "Pending";
  approved: string = "Approved";
  userInfo!: User;
  triggerR: boolean = false; triggerA: boolean = false;triggerP: boolean = false;


  constructor(private detail: ReviewDetailService, private us: UserServiceService) { }

  ngOnInit(): void {
    this.userInfo = this.us.getCurrentUserObject();
    this.id = this.userInfo.userid
  }

  //getting all critics review by id to be used on HTML
  getMyReview(): void {
    this.detail.getMyReviews(this.id).subscribe(
      response => this.reviews = (response)
    );
    this.triggerR = true;
  }

  //getting all critics pending review by id and status to be used on HTML
  getMyPending(): void {
    this.detail.getByIdAndStatus(this.id, this.pending).subscribe(
      response => this.pendings = (response)
    );
    this.triggerP = true;

  }

  getMyAccepted(): void {
    this.detail.getByIdAndStatus(this.id, this.approved).subscribe(
      response => this.accepted = (response)
    );
    this.triggerA = true;
  }






}