package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.EventType;

public interface EventTypeRepository extends JpaRepository<EventType,Integer> {
}
