export class Booking
{
    bookingId?: number;
    roomId?: number;
    applicantName?: string;
    roomName?: string;
    bookingDate?: string;
    startTime?: string;
    endTime?: string;
    status?: string;
    userId?: number
}

export class dtoBooking
{
    constructor(
        roomName: string,
        //Following data types should be Date, time.
        bookingDate: string,
        startTime: string,
        endTime: string,
        status: string,
        userId: number
    ){}
}