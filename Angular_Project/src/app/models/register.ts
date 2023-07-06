import { Time } from "@angular/common";

export class RegisterRecord
{
    userRecord?: string;
    timeSignedIn?: Time;
    dateSignedIn?: Date;
    event_type?: string;
    event_message?: string;
    sign_time?: string;
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