export class User
{
    email?: string;
    firstName?: string;
    lastName?: string;
    department?: string;
    imageUrl?: string;
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
        role : string,
    ){}


}