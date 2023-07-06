package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.team02.model.Facility;
import za.co.team02.model.SiteUser;

import java.util.Collection;
import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Integer>
{
    @Query("SELECT f FROM facility f WHERE f.user_id = ?1 ")
    Collection<Facility> getUserMeetings(Integer id);
}
