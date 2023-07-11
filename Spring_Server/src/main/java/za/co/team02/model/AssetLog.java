package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity(name="assets_logger")
@NoArgsConstructor
@AllArgsConstructor
public class AssetLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "asset_name")
    private String asset_name;

    @Column(name = "from_date")
    private Date from_date;

    @Column(name = "to_date")
    private Date to_date;

    @Column(name = "notes")
    private String notes;

    @Column(name = "log_status") //approved or declined
    private String log_status;

    @Column(name = "reason") //response message from admin for (approval or decline) status
    private String reason;

    @Column(name = "candidate_id")
    private Integer candidate_id;

    @Column(name = "candidate_name")
    private String candidate_name;
}
