import { Time } from "@angular/common";

export class RegisterRecord
{
    userRecord?: string;
    timeSignedIn?: Time;
    dateSignedIn?: Date;
    eventType?: string
}

export class dtoRegisterRecord
{
    constructor(
        userRecord: string,
        //Data types should be Date/ Datetime
        timeSignedIn: string,
        dateSignedIn: string,
        eventType: string,
    ){}
}