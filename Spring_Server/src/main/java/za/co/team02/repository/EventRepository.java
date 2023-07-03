package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.Event;
import za.co.team02.model.EventType;

public interface EventRepository extends JpaRepository<Event,Integer> {

}
