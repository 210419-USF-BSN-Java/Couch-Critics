export interface User {
    userId? : number,
    firstName : string,
    lastName : string,
    username : string,
    password : string,
    email : string,
    roleId? : { roleId: number, role : string},
    statusId? : { accStatusId: number, accStatus: string}
}