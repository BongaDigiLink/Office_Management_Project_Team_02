package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.BookingDTO;
import za.co.team02.dto.UpdateBookingDTO;
import za.co.team02.model.Event;
import za.co.team02.model.Facility;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.FacilityRepository;
import za.co.team02.repository.UserRepository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

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
        facility.setUser_id(user.getUser_id());
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

    public List<BookingDTO> findAllRequestedRooms()
    {
        List<Facility> list =  facilityRepo.findAll();
        List<BookingDTO> list_of_bookings = new ArrayList<>();

        try
        {
            for(Facility obj: list)
            {
                SiteUser user = userRepository.findById(obj.getUser_id()).get();
                BookingDTO bookings = new BookingDTO();

                bookings.setBookingId(obj.getId());
                bookings.setApplicant_name(user.getFirstName()+" "+user.getLastName());
                bookings.setBookingDate(obj.getDate());
                bookings.setStart_time(obj.getStart_time());
                bookings.setEnd_time(obj.getEnd_time());
                bookings.setRoom_name(obj.getRoom_name());
                bookings.setStatus(obj.getStatus());

                list_of_bookings.add(bookings);
            }
        }
        catch (Exception e)
        {
            //return e.printStackTrace();
            return null;
        }

        return list_of_bookings;
    }

    public boolean updatingMeetingRoomBooking(UpdateBookingDTO data)
    {
        try
        {
            Facility bookingToUpdate = facilityRepo.findById(data.getBooking_id()).get();
            bookingToUpdate.setStatus(data.getStatus());

            facilityRepo.save(bookingToUpdate);
            return true;
        }
        catch (Exception e)
        {
           System.out.println(e);
           return false;
        }
    }


    /**
     * @param userEmail - the current user
     * @return - list of all bookings of this user.
     */
    public List<Facility> findAllRequestedRoomsByUser(String userEmail)
    {
        SiteUser user = userRepository.findByEmail(userEmail).get();
        return facilityRepo.getUserMeetings(user.getUser_id()).stream().toList();
    }


    //End Of User Functions

    //Start of Admin Functions

}
