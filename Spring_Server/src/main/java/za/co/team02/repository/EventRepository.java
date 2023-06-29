package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
