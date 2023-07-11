export class Booking
{
    bookingId?: number;
    roomId?: number;
    applicant_name?: string;
    room_name?: string;
    bookingDate?: string;
    start_time?: string;
    end_time?: string;
    status?: string;
    user_id?: number
}

export class dtoBooking
{
    constructor(
        room_name: string,
        //Following data types should be Date, time.
        bookingDate: string,
        start_time: string,
        end_time: string,
        status: string,
        user_id: number
    ){}
}