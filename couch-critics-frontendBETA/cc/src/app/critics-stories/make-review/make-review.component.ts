import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-make-review',
  templateUrl: './make-review.component.html',
  styleUrls: ['./make-review.component.css']
})
export class MakeReviewComponent implements OnInit {
  title = "Create Movie Review";
  constructor() { }

  ngOnInit(): void {
  }

}
