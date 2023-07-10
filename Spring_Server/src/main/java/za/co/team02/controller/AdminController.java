package za.co.team02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.Asset;
import za.co.team02.model.Facility;
import za.co.team02.repository.FacilityRepository;
import za.co.team02.service.AdminService;
import za.co.team02.service.FacilityService;
import za.co.team02.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1")
public class AdminController {

    private final FacilityRepository facilityRepo;
    private final AdminService adminServiceOBJ;
    private FacilityService facilityService;
    private UserService userService;

    /**
     * Constructor for the CustomerController class.
     *
     * @param facilityRepo
     * @param adminServiceArg The service used to perform user-related operations.
     */
    // Service Constructor
    public AdminController(FacilityRepository facilityRepo, AdminService adminServiceArg, FacilityService facilityService, UserService userService) {
        this.facilityRepo = facilityRepo;
        this.adminServiceOBJ = adminServiceArg;
        this.facilityService = facilityService;
        this.userService = userService;
    }

    //Assets
    //

    // Create Operation

    /**
     * admin
     * controller - add user
     */
    @PostMapping("/add-user")
    public String addUser(@RequestBody UserDTO userDto, Errors errors) {
        if(errors.hasErrors()){
            System.out.println("Contact form validation failed due to : " + errors.toString());
            return "user.component.html";
        }

        this.userService.addUser(userDto);
        return "redirect:/contact";
    }

    /**
     * Endpoint for creating a new asset.
     *
     * @param asset The asset object to be created.
     * @return The created asset object.
     */
    @PostMapping("/add-asset")
    public Asset createAsset(@RequestBody Asset asset) {
        try {
            return adminServiceOBJ.createAsset(asset);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    //Read Operation

    /**
     * Endpoint for retrieving all assets.
     *
     * @return A list of all assets.
     */
    @GetMapping("/all-assets")
    public List<Asset> getAllAssets() {
        try {
            return adminServiceOBJ.findAllAsserts();
        } catch (Exception e) {
            System.out.println(HttpStatus.NO_CONTENT);
            return null;
        }
    }

    //Update Operation

    /**
     * Endpoint for updating a customer.
     *
     * @param id    The ID of the customer to update.
     * @param asset The updated customer object.
     * @return The updated customer object.
     */
    @PutMapping("/update-asset/{id}")
    public Asset updateAsset(@PathVariable("id") Integer id, @RequestBody Asset asset) {

        asset.setCandidateId(id);
        try {
            return adminServiceOBJ.updateAsset(asset);
        } catch (Exception e) {
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    //Delete Operation

    /**
     * Endpoint for deleting a asset.
     *
     * @param id The ID of the asset to delete.
     */
    @DeleteMapping("/delete-asset")
    public void deleteAsset(@PathVariable("id") Integer id) {
        try {
            adminServiceOBJ.deleteAsset(id);
        } catch (Exception e) {
            System.out.println(HttpStatus.NO_CONTENT);
        }
    }

    //

    //@PatchMapping("/facility/{id}/{status}")
    @PatchMapping("/update-facility-request/{id}/{status}")
    public ResponseEntity<Facility> updateEmployeePartially(@PathVariable Integer id, @PathVariable String status) {
        try {
            Facility facility = facilityRepo.findById(id).get();
            facility.setStatus(status);
            return new ResponseEntity<Facility>(facilityRepo.save(facility), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Read Operation

    /**
     * Endpoint for retrieving all Requested Meeting Rooms.
     *
     * @return A list of all assets.
     */
    @GetMapping("/user/get-all-facility-requests")
    public List<Facility> getAllRequestedRooms(Facility facility)
    {
        try {
            return facilityService.findAllRequestedRooms();
        } catch (Exception e) {
            System.out.println(HttpStatus.NO_CONTENT);
            return null;
        }
    }
}