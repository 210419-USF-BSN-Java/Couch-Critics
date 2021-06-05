import {review} from '../models/review-interface';

export const REVIEWS : review[] = [
    {reviewId : 1, movieId: 11, movieName :'Avengers', authorId : 1, review : "great", submitted:"today", managerId :1, reviewStatus: 'approved', likes:0, dislikes:1},
    {reviewId : 2, movieId: 12, movieName :'Ted', authorId : 1, review : "funny", submitted:"today", managerId :2, reviewStatus: 'approved', likes:0, dislikes:1 },
    {reviewId : 3, movieId: 13, movieName :'Spiderman', authorId : 1, review : "awesome", submitted:"today", managerId :3, reviewStatus: 'pending', likes:0, dislikes:1 },
    {reviewId : 4, movieId: 14, movieName :'Mighty Ducks', authorId : 1, review : "Inspiring", submitted:"today", managerId :2, reviewStatus: 'denied', likes:0, dislikes:1}
];
// my list