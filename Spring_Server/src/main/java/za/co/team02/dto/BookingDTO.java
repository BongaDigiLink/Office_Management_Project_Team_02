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
    String applicantName;
    String roomName;
    Date bookingDate;
    String startTime;
    String endTime;
    String status;
}
