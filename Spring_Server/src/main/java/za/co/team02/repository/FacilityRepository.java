package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
}
