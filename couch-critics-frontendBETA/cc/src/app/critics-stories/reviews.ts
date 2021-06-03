import {review} from '../models/review-interface';

export const REVIEWS : review[] = [
    {reviewId : 1, movieId: 11, movieName :'Avengers', authorId : 1, movieReview : "great", submitted:"today", managerId :1, reviewStatus: 'approved', likes:0, dislikes:0},
    {reviewId : 2, movieId: 12, movieName :'Ted', authorId : 1, movieReview : "funny", submitted:"today", managerId :2, reviewStatus: 'approved', likes:0, dislikes:0},
    {reviewId : 3, movieId: 13, movieName :'Spiderman', authorId : 1, movieReview : "awesome", submitted:"today", managerId :3, reviewStatus: 'pending', likes:0, dislikes:0},
    {reviewId : 4, movieId: 14, movieName :'Mighty Ducks', authorId : 1, movieReview : "Inspiring", submitted:"today", managerId :2, reviewStatus: 'denied', likes:0, dislikes:0},
];
// my list