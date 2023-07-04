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
    @Column(name = "id")
    private int Id;

    @Column(name = "event_id")
    private int event_id;

    @Column(name = "date_time")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
//    private LocalDateTime date_time;
    private String sign_time;

    @Column(name = "event_message")
    private String event_message;

    @Column(name = "event_type")
    private String event_type;

    //@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Integer user_id;

}
