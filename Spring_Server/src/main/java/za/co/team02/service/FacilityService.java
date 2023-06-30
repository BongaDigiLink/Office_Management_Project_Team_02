package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.model.Asset;
import za.co.team02.model.Facility;
import za.co.team02.repository.FacilityRepository;

import java.util.List;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepo;
    public FacilityService(FacilityRepository facilityRepoArg){
        this.facilityRepo = facilityRepoArg;

    }

    /**
     * Role: User
     * Creates a new customer and saves it to the repository.
     * @param facility The facility object to create.
     * @return The created asset object.
     */
    public Facility createFacilityRequest(Facility facility){
        return facilityRepo.save(facility);
    }

    /**
     * Role: User
     * Retrieves all facility bookings from the repository.
     * @return A list of all meeting room bookings.
     */

    public List<Facility> findAllMeetingRooms(){
        return facilityRepo.findAll();
    }


}