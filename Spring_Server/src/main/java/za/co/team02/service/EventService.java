package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.EventDTO;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.Event;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.EventRepository;
import za.co.team02.repository.UserRepository;

@Service
public class EventService {

    private EventRepository eventRepository;
    private UserRepository userRepository;

    public EventService(EventRepository eventRepository,UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public EventDTO logEvent(EventDTO eventDTO){
        Event event = new Event();

        // convert DTO to entity
        event.setDateTime(eventDTO.getDateTime());
        event.setUser(eventDTO.getUser());

        Event newEvent = eventRepository.save(event);

        //convert entity to DTO
        EventDTO eventResponse = new EventDTO();
        eventResponse.setEventId(newEvent.getEventId());
        eventResponse.setUser(newEvent.getUser());
        return eventResponse;
    }
}
