package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.model.Asset;
import za.co.team02.model.AssetLog;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.AssetLoggerRepository;
import za.co.team02.repository.UserRepository;

import java.util.List;

@Service
public class AssetLoggerService
{
    private final AssetLoggerRepository assetLoggerRepository;
    private final UserRepository userRepository;



    public AssetLoggerService(AssetLoggerRepository assetRepository, UserRepository userRepository)
    {
        this.assetLoggerRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public List<AssetLog> getLoggedInUserLogs(String userEmail)
    {
        return assetLoggerRepository.getUserLogs(getUserId(userEmail)).stream().toList();
    }

    public List<AssetLog> getAllUserLogs()
    {
        return assetLoggerRepository.findAll().stream().toList();
    }

    private int getUserId(String userEmail)
    {
        return userRepository.findByEmail(userEmail).get().getId();
    }

    public boolean createNewAssetLog(String userEmail, AssetLog assetLog)
    {
        if(assetLog != null && userEmail != null)
        {
            assetLog.setCandidate_id(getUserId(userEmail));
            assetLog.setLog_status("Pending");
            assetLoggerRepository.save(assetLog);

            return true;
        } else
        {
            return false;
        }
    }

    // Admin Methods
     public boolean makeLogStatus()
     {
         return false;
     }

    public boolean approveAssets() {
        for (AssetLog assetLog : getAllUserLogs()) {
            if (assetLog != null &&  assetLog.getCandidate_id()!= null) {
                assetLog.setCandidate_id(assetLog.getCandidate_id());
                assetLog.setLog_status("Approved");
                assetLoggerRepository.save(assetLog);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
