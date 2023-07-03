package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.EventDTO;
import za.co.team02.model.Event;
import za.co.team02.repository.EventRepository;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDTO logEvent(EventDTO eventDTO){
        Event event = new Event();

        // convert DTO to entity
//        event.setCandidateLoginId(eventDTO.getCandidateLoginId());
        event.setDateTime(eventDTO.getDateTime());
//        event.setUser(eventDTO.getUser());

        Event newEvent = eventRepository.save(event);

        //convert entity to DTO
        EventDTO eventResponse = new EventDTO();
        eventResponse.setEventId(newEvent.getEventId());
//        eventResponse.setCandidateLoginId(newEvent.getCandidateLoginId());
//        eventResponse.setUser(newEvent.getUser());
//        eventResponse.setUser(newEvent.getUser());
        return eventResponse;
    }
}
