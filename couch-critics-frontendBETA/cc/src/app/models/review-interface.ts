import { getLocaleNumberSymbol } from "@angular/common";
import { Identifiers } from "@angular/compiler";

export interface review{
    reviewId: number;
    movieId: number;
    movieName: String;
    authorId: number;
    movieReview: String;
    submitted: String;
    managerId: number;
    reviewStatus: String;
    likes : number;
    dislikes : number;

}