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
public class Facility   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_name")
    private String trainingRoomName;

    @Temporal(TemporalType.DATE)
    Date date;

    @Column (name = "start-time")
    private String startTime;

    @Column (name = "end-time")
    private String endTime;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingRoomName() {
        return trainingRoomName;
    }

    public void setTrainingRoomName(String trainingRoomName) {
        this.trainingRoomName = trainingRoomName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
//    @Column(name = "room_type")
//    private String trainingRoomType;
//
//    @Column(name = "availability")
//    private boolean availability;
//
//    @Column(name = "time")
//    private LocalDateTime time;
}
