package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.EventDTO;
import za.co.team02.model.Event;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.EventRepository;
import za.co.team02.repository.UserRepository;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;
    private UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository)
    {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public EventDTO logEvent(String email, EventDTO eventDTO)
    {
        Event event = new Event();

        // convert DTO to entity
        if(eventDTO.getSign_inTime() != null)
        {
            event.setSignTime(eventDTO.getSign_inTime());
        }
        else
        {
            event.setSignTime(eventDTO.getSign_outTime());
        }

        event.setUserId(userRepository.findByEmail(email).get().getId());
        event.setEventMessage(eventDTO.getEvent_message());
        event.setEventType(eventDTO.getEvent_type());

        Event newEvent = eventRepository.save(event);

        //convert entity to DTO
        EventDTO eventResponse = new EventDTO();
        eventResponse.setEventId(newEvent.getEventId());
//        eventResponse.setCandidateLoginId(newEvent.getCandidateLoginId());
        eventResponse.setSign_inTime(newEvent.getSignTime());

        return eventResponse;
    }
    public List<Event> getMyAttendance(String email)
    {
        SiteUser user = userRepository.findByEmail(email).get();
        return eventRepository.getAttendance(user.getId()).stream().toList();
    }
}
