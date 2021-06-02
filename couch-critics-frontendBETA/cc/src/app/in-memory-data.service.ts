import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

//This Service is designed to have Reviews to test with
export class InMemoryDataService {
  //This is our Mock Database
  createDb() {
    const reviews = [
      { reviewId:1, movieId:1, movieName:'American Pie', authorId: 1, review: 'Super Funny!', submittedTime : new Date(), managerId: 1, reviewStatus: 1, likes:1, dislikes:1},
      { reviewId:2, movieId:2, movieName:'Scary Movie', authorId: 1, review: 'Super Scary!', submittedTime : new Date(), managerId: 1, reviewStatus: 1, likes:1, dislikes:1},
      { reviewId:3, movieId:3, movieName:'A Walk to Remember', authorId: 1, review: 'Super Romantic!', submittedTime : new Date(), managerId: 1, reviewStatus: 1, likes:1, dislikes:1},
      { reviewId:4, movieId:4, movieName:'Napoleon Dynamite', authorId: 1, review: 'Super Boring!', submittedTime : new Date(), managerId: 1, reviewStatus: 1, likes:1, dislikes:1},
      { reviewId:5, movieId:5, movieName:'Star Wars', authorId: 1, review: 'Super Awesome!', submittedTime : new Date(), managerId: 1, reviewStatus: 1, likes:1, dislikes:1}
    ];
    return {reviews};
  }

  constructor() { }
}
