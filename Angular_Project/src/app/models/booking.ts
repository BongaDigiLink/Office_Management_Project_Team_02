export class Booking
{
    bookingId?: number;
    roomId?: number;
    roomName?: string;
    roomCapacity?: string;
    bookingDate?: string;
    bookingTime?: string;
}

export class dtoBooking
{
    constructor(
        roomName: string,
        //Following data types should be Date, time.
        bookingDate: string,
        start_time: string,
        end_time: string
    ){}
}