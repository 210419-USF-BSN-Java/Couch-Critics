import { Component, OnInit } from '@angular/core';
import { InMemoryDataService } from '../in-memory-data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private inMemoryDataService: InMemoryDataService) {}

  ngOnInit(): void {
    this.getReviews;
  }

  getReviews(): void {
    this.inMemoryDataService.createDb().reviews;
  }

}
