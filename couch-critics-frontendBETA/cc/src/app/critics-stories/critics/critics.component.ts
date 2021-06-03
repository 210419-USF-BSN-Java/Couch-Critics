import { Component, OnInit } from '@angular/core';
import {review} from '../../models/review-interface';
import {ReviewDetailService} from '../../services/review-detail.service';

@Component({
  selector: 'app-critics',
  templateUrl: './critics.component.html',
  styleUrls: ['./critics.component.css']
})
export class CriticsComponent implements OnInit {
  title = "Critics Homepage";

  //making a variable out of the object made from the import of REVIEWS
  reviews : review[] = [];



  constructor(private detail : ReviewDetailService) { }

  ngOnInit() {
    this.getDetail();
  }

 

getDetail() : void{
  this.detail.getReview().subscribe(reviews=>this.reviews=reviews);
}
}