package za.co.team02.dto;

import jakarta.persistence.*;
import lombok.Data;
import za.co.team02.model.SiteUser;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private int eventId;
    private int candidateLoginId;
    private LocalDateTime dateTime;
    private SiteUser user;
}

