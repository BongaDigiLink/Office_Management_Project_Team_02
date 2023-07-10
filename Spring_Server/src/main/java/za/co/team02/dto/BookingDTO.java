package za.co.team02.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class BookingDTO
{
    int bookingId;
    int roomId;
    String applicant_name;
    String room_name;
    Date bookingDate;
    String start_time;
    String end_time;
    String status;
}
