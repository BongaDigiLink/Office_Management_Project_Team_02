package za.co.team02.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "eventss")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    //@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "candidatelogin_id")
    private int candidatelogin_id;

    @Column(name = "evenType_id")
    private int eventType_id;

//    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private int candidate_id;

    @Column(name = "event_id")
    private int event_id;

    @Column(name = "Time")
    private String time;

    @Column(name = "DATE")
    String date;

    @Column(name="Event")
    String event;
}
