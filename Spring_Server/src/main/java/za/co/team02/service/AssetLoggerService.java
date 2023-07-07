package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.model.Asset;
import za.co.team02.model.AssetLog;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.AssetLoggerRepository;
import za.co.team02.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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
        return assetLoggerRepository.findAll();
    }

    private int getUserId(String userEmail)
    {
        return userRepository.findByEmail(userEmail).get().getId();
    }

    private Optional<SiteUser> getUser(String userEmail)
    {
        return userRepository.findByEmail(userEmail);
    }

    public boolean createNewAssetLog(String userEmail, AssetLog assetLog)
    {
        if(assetLog != null && userEmail != null)
        {

            assetLog.setCandidate_id(getUserId(userEmail));
            assetLog.setCandidate_name(getUser(userEmail).get().getFirstName()+" "+getUser(userEmail).get().getLastName());
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

    public boolean approveAssets(int requestId) {
        AssetLog assetLog = assetLoggerRepository.findById(requestId).get();
        assetLog.setLog_status("Approved");
        assetLoggerRepository.save(assetLog);
        return true;
    }
}
