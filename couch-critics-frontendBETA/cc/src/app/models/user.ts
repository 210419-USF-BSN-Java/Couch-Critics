export interface User {
    userid? : number, //switched from id to userid to match response format
    firstName : string,
    lastName : string,
    username : string,
    password : string,
    email : string,
    roleId? : { roleId: number, role : string},
    statusId? : { accStatusId: number, accStatus: string}
}