package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.EventDTO;
import za.co.team02.dto.EventTypeDTO;
import za.co.team02.model.Event;
import za.co.team02.model.EventType;
import za.co.team02.repository.EventTypeRepository;

@Service
public class EventTypeService {
    private EventTypeRepository eventTypeRepository;

    public EventTypeService(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    public EventTypeDTO logEvent(EventTypeDTO eventTypeDTO){

        // Create a new entity
        EventType eventType = new EventType();

        // convert DTO to entity
        eventType.setEvent_name(eventTypeDTO.getEventName());

        // save the entity to the database
        EventType newEventType = eventTypeRepository.save(eventType);

        //create a new entity response
        EventTypeDTO eventTypeResponse = new EventTypeDTO();

        //convert entity to DTO
        eventTypeResponse.setEventTypeId(newEventType.getEventType_id());
        eventTypeResponse.setEventName(newEventType.getEvent_name());

        return eventTypeResponse;
    }
}
