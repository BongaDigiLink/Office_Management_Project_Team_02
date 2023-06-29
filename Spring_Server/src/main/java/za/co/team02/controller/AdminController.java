package za.co.team02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import za.co.team02.model.Asset;
import za.co.team02.repository.AssetRepository;
import za.co.team02.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminServiceOBJ;

    /**
     * Constructor for the CustomerController class.
     * @param adminServiceArg The service used to perform user-related operations.
     */
    // Service Constructor
    public AdminController(AdminService adminServiceArg){
        this.adminServiceOBJ = adminServiceArg;
    }

    //Assets
    //

    // Create Operation
    /**
     * Endpoint for creating a new asset.
     * @param asset The asset object to be created.
     * @return The created asset object.
     */
    @PostMapping("/add-asset")
    public Asset createAsset(@RequestBody Asset asset){

        try {
            return  adminServiceOBJ.createAsset(asset);
        }

        catch(Exception e){

            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;

        }

    }

    //Read Operation
    /**
     * Endpoint for retrieving all assets.
     * @return A list of all assets.
     */
    @GetMapping("/all-assets")
    public List<Asset> getAllAssets(){
        try{
            return adminServiceOBJ.findAllAsserts();
        }

        catch (Exception e) {
            System.out.println(HttpStatus.NO_CONTENT);
            return null;
        }
    }

    //Update Operation
    /**
     * Endpoint for updating a customer.
     * @param id The ID of the customer to update.
     * @param asset The updated customer object.
     * @return The updated customer object.
     */
    @PutMapping("/update-asset/{id}")
    public Asset updateAsset(@PathVariable("id") Integer id, @RequestBody Asset asset){

        asset.setCandidateId(id);
        try{
            return adminServiceOBJ.updateAsset(asset);
        }

        catch(Exception e){
            System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    //Delete Operation
    /**
     * Endpoint for deleting a asset.
     * @param id The ID of the asset to delete.
     */
    @DeleteMapping("/delete-asset")
    public void deleteAsset (@PathVariable("id") Integer id){
        try {
            adminServiceOBJ.deleteAsset(id);
        }
        catch (Exception e ){
            System.out.println(HttpStatus.NO_CONTENT);
        }
    }












}
