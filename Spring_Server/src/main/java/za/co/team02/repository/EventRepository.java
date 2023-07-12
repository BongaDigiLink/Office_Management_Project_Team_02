package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.team02.model.Event;
import za.co.team02.model.EventType;
import za.co.team02.model.SiteUser;

import java.util.Collection;

public interface EventRepository extends JpaRepository<Event,Integer>
{
    @Query("SELECT e FROM event e WHERE e.userId = ?1 ")
    Collection<Event> getAttendance(Integer user_id);

}
