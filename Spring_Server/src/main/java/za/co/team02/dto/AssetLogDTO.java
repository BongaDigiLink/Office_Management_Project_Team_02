package za.co.team02.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AssetLogDTO
{
    Integer id; //For admin accept or decline
    Integer candidateId; //user making the log
    String candidateName; //name of the user making the log
    String assetName;
    Date fromDate;
    Date toDate;
    String logStatus; //Approved or Declined
    String notes; //Notes from user, reason for asset log.
    String reason; //Reason for approval or decline of asset log
}
