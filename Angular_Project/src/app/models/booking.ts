export class Booking
{
    bookingId?: number;
    roomId?: number;
    trainingRoomName?: string;
    roomCapacity?: string;
    bookingDate?: string;
    start_time?: string;
    end_time?: string;
    status?: string;
    user_id?: number
}

export class dtoBooking
{
    constructor(
        trainingRoomName: string,
        //Following data types should be Date, time.
        bookingDate: string,
        start_time: string,
        end_time: string,
        status: string,
        user_id: number
    ){}
}