package za.co.team02.dto;

import lombok.Data;

@Data
public class UpdateBookingDTO
{
    String admin_user;
    int booking_id;
    String status;
}
