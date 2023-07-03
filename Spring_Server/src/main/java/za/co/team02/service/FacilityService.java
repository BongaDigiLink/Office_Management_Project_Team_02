package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.team02.model.Facility;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.FacilityRepository;
import za.co.team02.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityService {

    private FacilityRepository facilityRepo;
    private UserRepository userRepository;

    public FacilityService(FacilityRepository facilityRepoArg, UserRepository user)
    {
        this.facilityRepo = facilityRepoArg;
        this.userRepository = user;

    }

    // Start Of User Functions
    /**
     * Role: User
     * Creates a new customer and saves it to the repository.
     * @param facility The facility object to create.
     * @return The created asset object.
     */
    public Facility createFacilityRequest(String userEmail, Facility facility)
    {
        SiteUser user = userRepository.findByEmail(userEmail).get();
        //make checks to see whether this request doesn't conflict with existing meetings

        //Save new booking
        facility.setUser_id(user.getAdminId());
        facility.setStatus("Pending");
        System.out.println(facility);

         return facilityRepo.save(facility);

//        if(facility.getStatus() == null)
//        {
//            facility.setStatus("Pending");
//        }
//        return facilityRepo.save(facility);
    }

    /**
     * Role: User
     * Retrieves all facility bookings from the repository.
     * @return A list of all meeting room bookings.
     */

    public List<Facility> findAllRequestedRooms()
    {
        return facilityRepo.findAll();
    }

    /**
     * @param userEmail - the current user
     * @return - list of all bookings of this user.
     */
    public List<Facility> findAllRequestedRoomsByUser(String userEmail)
    {
        SiteUser user = userRepository.findByEmail(userEmail).get();
        return facilityRepo.getUserMeetings(user.getAdminId()).stream().toList();
    }


    //End Of User Functions

    //Start of Admin Functions

}
