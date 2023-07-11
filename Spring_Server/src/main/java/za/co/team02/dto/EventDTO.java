package za.co.team02.dto;

import lombok.Data;
import za.co.team02.model.SiteUser;

import java.time.LocalDateTime;

@Data
public class EventDTO
{
    //Incoming Data
    private String user_email; //use this for candidate_id
    private String time;
    private String event_name; //use this for event_id
    private String event_message; //Column - Event

    //Outgoing Data
    private int event_id;
    private String candidate_name;
}

