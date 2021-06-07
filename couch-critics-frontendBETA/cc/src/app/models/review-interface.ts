import { getLocaleNumberSymbol } from "@angular/common";
import { Identifiers } from "@angular/compiler";

export interface review{
    reviewId?: number;
    movieId?: number | undefined;
    movieName?: string | undefined;
    authorId?: number;
    review?: string;
    submit?: string;
    managerId?: number;
    reviewStatus?: string;
    likes? : number;
    dislikes? : number;
    

}