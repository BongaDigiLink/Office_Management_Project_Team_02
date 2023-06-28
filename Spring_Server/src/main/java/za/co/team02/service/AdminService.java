package za.co.team02.service;

import za.co.team02.model.Asset;
import za.co.team02.repository.AssetRepository;

import java.util.List;

public class AdminService {

    // Assets Service Implementation
    private final AssetRepository assetRepository;

    public AdminService(AssetRepository assetRepo){

        this.assetRepository = assetRepo;
    }

    /**
     * Creates a new customer and saves it to the repository.
     * @param asset The customer object to create.
     * @return The created asset object.
     */
    public Asset createAsset( Asset asset){
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
     * @param asset The updated asset object.
     * @return The updated asset object.
     */


    public Asset updateAsset(Asset asset){

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

}