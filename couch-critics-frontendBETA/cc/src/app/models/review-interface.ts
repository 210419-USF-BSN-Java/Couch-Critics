import { getLocaleNumberSymbol } from "@angular/common";
import { Identifiers } from "@angular/compiler";

export interface review{
    reviewId: number;
    movieId: number;
    movieName: string;
    authorId: number;
    review: string;
    submitted: string;
    managerId: number;
    reviewStatus: string;
    likes : number;
    dislikes: string;
    

}