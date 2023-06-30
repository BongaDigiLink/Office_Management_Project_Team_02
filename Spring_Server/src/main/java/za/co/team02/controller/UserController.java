package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.EventDTO;
import za.co.team02.dto.UserDTO;
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


    //Request Facility Post

    @PostMapping("/create-facility-request")
    public Facility createFacility(@RequestBody Facility facility){

        try {
            return  facilityService.createFacilityRequest(facility);
        }

        catch(Exception e){

            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;

        }

    }
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
     * controller - make  meeting booking
     */


    /**
     * user
     * controller -  complete a register
     */
    @PostMapping("/sign-register")
    public String completeRegister(@RequestBody EventDTO eventDTO) {
        this.eventService.logEvent(eventDTO);
        return "redirect:/event_register";
    }


    /**
     * user
     * controller - request food
     */

}
