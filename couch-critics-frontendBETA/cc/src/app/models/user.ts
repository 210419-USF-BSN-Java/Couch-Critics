export interface User {
    userId? : number,
    firstName : string,
    lastName : string,
    username : string,
    password : string,
    email : string,
    roleId? : {roleid:number, role:string},
    statusId? : number;
}
