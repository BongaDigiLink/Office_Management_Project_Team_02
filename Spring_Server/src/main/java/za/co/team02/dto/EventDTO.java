package za.co.team02.dto;

import lombok.Data;
import za.co.team02.model.SiteUser;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private int eventId;
    private int user_id;
//    private LocalDateTime dateTime;
    private String sign_inTime;
    private String sign_outTime;
    private String event_type;
    private String event_message;
}

