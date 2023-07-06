package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "event_type")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int eventTypeId;

    @Column(name = "event_name")
    private String eventName;

}
