package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.*;
import za.co.team02.model.*;
import za.co.team02.service.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController
{
    private UserService userService;
    private EventService eventService;
    private EventTypeService eventTypeService;
    private FacilityService facilityService;
    private FoodService foodService;
    private AssetLoggerService assetLoggerService;

    @Autowired
    public UserController(UserService userService,
                          EventService eventService,
                          EventTypeService eventTypeService,
                          FacilityService facilityService,
                          FoodService foodService,
                          AssetLoggerService assetLoggerService) {
        this.userService = userService;
        this.eventService = eventService;
        this.facilityService = facilityService;
        this.eventTypeService = eventTypeService;
        this.foodService = foodService;
        this.assetLoggerService = assetLoggerService;
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
    public Facility createFacility(@PathVariable("email") String email,
                                   @RequestBody Facility facility)
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

//    @PostMapping("/asset-register/{email}")
//    public ResponseEntity<?> createAssetLog(@PathVariable("email") String email,
//                                @RequestBody AssetLogDTO loggedAssetDTO)
//    {
//        try
//        {
//            if(assetLoggerService.createNewAssetLog(email, loggedAssetDTO)!=null)
//            {
//                return new ResponseEntity<>("Success", HttpStatus.OK);
//            };
//            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
//        }
//        catch (Exception e)
//        {
//            return null;
//        }
//    }

    @PostMapping("/asset-register/{email}")
    public AssetLogDTO createAssetLog(@PathVariable("email") String email,
                                            @RequestBody AssetLogDTO loggedAssetDTO)
    {
        return assetLoggerService.createNewAssetLog(email, loggedAssetDTO);
    }

    @GetMapping("/get-my-asset-log/{email}")
    public ResponseEntity<List<AssetLog>> getMyAssetLogs(@PathVariable("email") String userEmail)
    {
        if(userService.getSingleUser(userEmail) != null)
        {
             List<AssetLog> logs = assetLoggerService.getLoggedInUserLogs(userEmail);
             return new ResponseEntity<>(logs, HttpStatus.OK);
        }

        return null;
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
    @GetMapping("/get-dashboard-data/{email}")
    public DashBoardData getDashboardData(@PathVariable("email") String email)
    {
        DashBoardData newObj = userService.getDashBoardData(email);
        return newObj;
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
     * controller - get users record register
     */
    @GetMapping("/my-register/{email}")
    public List<Event> getMyRecordRegister(@PathVariable("email") String email)
    {
        return eventService.getMyAttendance(email);
    }


    /**
     * user
     * controller -  complete a register
     */
    @PostMapping("/sign-register/{email}")
    public ResponseEntity<EventDTO> completeRegister(@PathVariable("email") String email,
                                                     @RequestBody EventDTO eventDTO)
    {
        System.out.println(eventDTO);
        return new ResponseEntity<>(this.eventService.logEvent(email,
                eventDTO), HttpStatus.OK);
    }

    @PostMapping("/sign-type")
    public String completeRegister(@RequestBody EventTypeDTO eventTypeDTO) {
        this.eventTypeService.logEvent(eventTypeDTO);
        return "redirect:/event_register";
    }

    /**
     * user
     * controller - request food
     */
    @GetMapping("/request-food")
    public List<Integer> requestNoodles(@PathVariable String email) {
       return this.foodService.getFood(email);
    }
}
