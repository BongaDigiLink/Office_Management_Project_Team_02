package za.co.team02.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AssetLogDTO
{

    String asset_name;
    Date from_date;
    Date to_date;
    String notes; //Notes from user, reason for asset log.

    String log_status; //Approved or Declined
    String reason; //Reason for approval or decline of asset log
    Integer candidate_id; //user making the log
    String candidate_name; //name of the user making the log

    //For admin accept or decline
    int id;
    String admin_user;
//    candidate_name?: string;
//    asset_name?: string;
//    from_date?: string;
//    to_date?: string;
//    notes?: string;
//    log_status?: string;
//    reason?: string;

}
