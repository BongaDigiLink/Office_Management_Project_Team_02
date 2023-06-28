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

    public AdminController(AdminService adminServiceArg){
        this.adminServiceOBJ = adminServiceArg;
    }

    //Assets
    //
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







}
