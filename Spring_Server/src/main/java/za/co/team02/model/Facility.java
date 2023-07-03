package za.co.team02.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Entity(name = "facility")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false)
    private String trainingRoomName;

    @Temporal(TemporalType.DATE)
    Date date;

    @Column (name = "start_time", nullable = false)
    private String startTime;

    @Column (name = "end_time",nullable = false)
    private String endTime;

    // Nullable Awaiting Admin Approval
    @Column(name = "status")
    private String status;

    @Column(name = "user_id")
    private Integer userId;
}
