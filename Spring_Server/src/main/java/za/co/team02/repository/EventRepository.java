package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.team02.model.Event;
import za.co.team02.model.EventType;
import za.co.team02.model.SiteUser;

import java.util.Collection;

public interface EventRepository extends JpaRepository<Event,Integer>
{
    @Query("SELECT e FROM Register_Events e WHERE e.User_id = ?1 ")
    Collection<Event> getAttendance(int candidate_id);

}
