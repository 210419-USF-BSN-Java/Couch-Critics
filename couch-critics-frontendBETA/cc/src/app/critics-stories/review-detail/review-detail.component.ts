import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import {review} from '../../models/review-interface';
import {ReviewDetailService} from '../../services/review-detail.service';

@Component({
  selector: 'app-review-detail',
  templateUrl: './review-detail.component.html',
  styleUrls: ['./review-detail.component.css']
})
export class ReviewDetailComponent implements OnInit {
  r: review | undefined;

  constructor(
    private route: ActivatedRoute,
    private detail: ReviewDetailService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getDetail();
  }

  getDetail(): void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.detail.getreview(id).subscribe(r => this.r = r);
  }

  goBack(): void {
    this.location.back();
  }

}