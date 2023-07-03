package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.EventDTO;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.Event;
import za.co.team02.model.Facility;
import za.co.team02.model.SiteUser;
import za.co.team02.service.EventService;
import za.co.team02.service.FacilityService;
import za.co.team02.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController
{
    private UserService userService;
    private EventService eventService;

    private FacilityService facilityService;

    @Autowired
    public UserController(UserService userService,EventService eventService, FacilityService facilityService) {
        this.userService = userService;
        this.eventService = eventService;
        this.facilityService = facilityService;
    }

    /**
     * admin
     * controller - add user
     */
    @PostMapping("/add-user")
    public String addUser(@RequestBody UserDTO userDto,Errors errors) {
        if(errors.hasErrors()){
            System.out.println("Contact form validation failed due to : " + errors.toString());
            return "user.component.html";
        }

        this.userService.addUser(userDto);
        return "redirect:/contact";
    }


    /**
     * admin
     * controller - view all users
     */
    @GetMapping("/all-users")
    public List<SiteUser> getUsers()
    {
        return userService.getUsers();
    }


    /**
     * admin
     * controller - edit a user (CRUD)
     */
    @GetMapping(path = "/user/{email}")
    public SiteUser getSingleUser(@PathVariable String email)
    {
        return userService.getSingleUser(email);
    }


    /**
     * admin
     * controller - edit a user (CRUD)
     */
    @PutMapping(path = "/update-user/{email}")
    public void updateStudent(
           @RequestBody SiteUser siteUser){
        userService.updateUser(siteUser);
    }


    //Start Of Facility End Points
    //Start User Facility Functions

    // Create Operation
    /**
     * Endpoint for creating a new asset.
     * @param facility The asset object to be created.
     * @return The created asset object.
     */
    @PostMapping("/user/create-facility-request/{email}")
    public Facility createFacility(@PathVariable("email") String email, @RequestBody Facility facility)
    {
        try
        {
            return  facilityService.createFacilityRequest(email, facility);
        }
        catch(Exception e)
        {
            //System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }


    /**
     *
     * @param email - current logged in user email
     * @return list of all facilities requested by this user.
     */
    @GetMapping("/user/user-facility-requests/{email}")
    public List<Facility> getUserRequestedRooms(@PathVariable("email") String email)
    {
        try
        {
            return facilityService.findAllRequestedRoomsByUser(email);
        }
        catch (Exception e)
        {
            System.out.println(HttpStatus.NO_CONTENT);
            return null;
        }
    }

    //End User Facility Functions


    /**
     * admin
     * controller - update food reserve
     */

    /**
     * Admin
     * controller - view all assets
     */

    /**
     * Admin
     * controller - manage an asset
     */

    /**
     * user
     * controller - update details
     */

    /**
     * user
     * controller - get users record register
     */
    @GetMapping("/my-register/{email}")
    public List<Event> getMyRecordRegister(@PathVariable("email") String email)
    {
        return null;
    }


    /**
     * user
     * controller -  complete a register
     */
    @PostMapping("/sign-register/{email}")
    public ResponseEntity<EventDTO> completeRegister(@PathVariable("email") String email, @RequestBody EventDTO eventDTO)
    {
        System.out.println(eventDTO);
        return new ResponseEntity<>(this.eventService.logEvent(email, eventDTO), HttpStatus.OK);
    }


    /**
     * user
     * controller - request food
     */

}
