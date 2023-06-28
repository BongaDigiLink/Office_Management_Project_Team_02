export class User
{
    email?: string;
    name?: string;
    surname?: string;
    imageUrl?: string;
    userType?: string;
    role?: string
}

export class dtoUser
{
    constructor(
        email: string,
        name: string,
        surname: string,
        imageUrl: string,
        role: string,
    ){}
}