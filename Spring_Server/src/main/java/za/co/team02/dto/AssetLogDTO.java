package za.co.team02.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AssetLogDTO
{

    String assetName;
    Date fromDate;
    Date toDate;
    String notes; //Notes from user, reason for asset log.

    String logStatus; //Approved or Declined
    String reason; //Reason for approval or decline of asset log
    Integer candidateId; //user making the log
    String candidateName; //name of the user making the log

    //For admin accept or decline
    int id;
    String adminUser;
//    candidate_name?: string;
//    asset_name?: string;
//    from_date?: string;
//    to_date?: string;
//    notes?: string;
//    log_status?: string;
//    reason?: string;

//
}
