package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "event_typee")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EventType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int eventType_id;

    @Column(name = "event_name")
    private String event_name;
}
