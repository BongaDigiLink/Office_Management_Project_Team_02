package za.co.team02.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;

//    @Column(name = "candidate_id")
//    private int candidateLoginId;

    @Column(name = "date_time")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime dateTime;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private SiteUser user;
}
