package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.EventDTO;
import za.co.team02.model.Event;
import za.co.team02.model.EventType;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.EventRepository;
import za.co.team02.repository.EventTypeRepository;
import za.co.team02.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class EventService
{
    private EventRepository eventRepository;
    private EventTypeRepository eventTypeRepository;
    private UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository, EventTypeRepository eventTypeRepository)
    {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    public boolean logEvent(EventDTO eventDTO)
    {
        Event event = new Event();
        SiteUser user = userRepository.findByEmail(eventDTO.getUser_email()).get();

        //event.setEvent_id(event.getEvent_id());
        event.setUser_id(user.getUser_id());
        event.setTime(eventDTO.getTime());
        event.setDate(eventDTO.getDate());
        event.setEvent(eventDTO.getEvent_message());
        System.out.println(event);

        Event newEvent = eventRepository.save(event);

        return true;
    }

    public List<Event> getMyAttendance(String email)
    {
//        SiteUser user = userRepository.findByEmail(email).get();
//        System.out.println(user);
//        System.out.println(user.getUser_id());
//
//        return eventRepository.getAttendance(user.getUser_id()).stream().toList();
        return null;
    }
}
