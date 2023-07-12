package za.co.team02.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Register_Events")
@Table(name = "Register_Events", schema="dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event
{
    @Id
    @GeneratedValue(generator= "register_events_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "Event_id")
    private int Event_id;

    @Column(name = "User_id")
    private int User_id;

    @Column(name = "Time")
    private String time;

    @Column(name = "Date")
    String date;

    @Column(name="Event_message")
    String event;
}
