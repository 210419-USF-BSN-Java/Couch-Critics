export interface User {
    userid? : number, //switched from id to userid to match response format
    firstName : string,
    lastName : string,
    username : string,
    password : string,
    email : string,
    roleId? : { roleId: number, role : string},
    statusid? : { accStatusId: number, accStatus: string}
}

//if accStatusId = 1, then activated, if accStatusId = 2 , then account is deactivated