export interface Review {
    reviewId : number,
    movieId : number,
    movieName : string,
    authorId : number,
    review : string,
    submittedTime : Date,
    managerId : number, 
    reviewSatus : number,
    likes : number,
    dislikes : number
}
