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


}
