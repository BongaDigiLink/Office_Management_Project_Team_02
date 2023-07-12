package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity(name="asset_logger")
@NoArgsConstructor
@AllArgsConstructor
public class AssetLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "log_status") //approved or declined
    private String logStatus;

    @Column(name = "reason") //response message from admin for (approval or decline) status
    private String reason;

    @Column(name = "candidate_id")
    private Integer candidateId;

    @Column(name = "candidate_name")
    private String candidateName;
}
