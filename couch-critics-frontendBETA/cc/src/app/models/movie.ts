export interface Movie {
    id : number,
    original_title : string,
    overview? : string,
    poster_path? : string,
    popularity? : number,
    vote_average? : number,
    vote_count? : number,
    imb_id? : string,
    genres?: {id:number, name:string,}


}
