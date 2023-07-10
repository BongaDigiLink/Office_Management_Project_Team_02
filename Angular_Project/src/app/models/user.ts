export class User
{
    email?: string;
    firstName?: string;
    lastName?: string;
    username?: string;
    userType?: string;
    role?: string
}

export class dtoUser
{
    constructor(
        name: string,
        surname: string,
        email: string,
        address: string,
        password: string,
        username: string,
        role : string,
    ){}

}