package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.DashBoardData;
import za.co.team02.model.Asset;
import za.co.team02.model.AssetLog;
import za.co.team02.repository.AssetLoggerRepository;
import za.co.team02.repository.AssetRepository;
import za.co.team02.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    // Assets Service Implementation
    private final AssetRepository assetRepository;
    private UserRepository userRepository;

    private final AssetLoggerRepository assetLoggerRepository;
    public AdminService(AssetRepository assetRepo,AssetLoggerRepository assetLoggerRepository, UserRepository userRepository){

        this.assetRepository = assetRepo;
        this.assetLoggerRepository = assetLoggerRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new customer and saves it to the repository.
     * @param asset The customer object to create.
     * @return The created asset object.
     */
    public Asset createAsset(Asset asset){
        return assetRepository.save(asset);
    }

    /**
     * Retrieves all assets from the repository.
     * @return A list of all assets.
     */

    public List<Asset> findAllAsserts(){
        return assetRepository.findAll();
    }

    /**
     * Updates an existing customer in the repository.
     *
     * @param asset The updated asset object.
     * @return The updated asset object.
     */

    public Asset updateAsset(Asset asset){

        //Optional<Asset> siteUser = assetRepository.findById(asset.getCandidateId());

                //.orElseThrow(()-> new IllegalStateException("user with email does not exist"));
    /*
        asset.setEquipmentName(asset.getEquipmentName());
        asset.setEquipmentStatus(asset.getEquipmentStatus());
        asset.setEquipmentCondition(asset.getEquipmentCondition());

    */
        return assetRepository.save(asset);
    }

    /**
     * Deletes  Asset from the repository by their ID.
     * @param id The ID of the Asset to delete.
     */
    public void deleteAsset(Integer id){
        assetRepository.deleteById(id);
    }

    // End of Asset end points
    public DashBoardData getAdminData()
    {
        DashBoardData data = new DashBoardData();

        data.setUserCount(userRepository.findAll().size());
        data.setMeetingsCount(446);
        data.setUserCount(3555);

        return data;
    }
}
