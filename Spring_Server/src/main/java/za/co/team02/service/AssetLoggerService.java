package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.AssetLogDTO;
import za.co.team02.model.Asset;
import za.co.team02.model.AssetLog;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.AssetLoggerRepository;
import za.co.team02.repository.UserRepository;

import java.util.ArrayList;
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

    public List<AssetLogDTO> getAllUserLogs()
    {
        List<AssetLogDTO> list = new ArrayList<>();
        List<AssetLog> logs =  assetLoggerRepository.findAll();

        for(AssetLog assetLog: logs)
        {
            AssetLogDTO assetLogDTO = new AssetLogDTO();
             if(assetLog.getLogStatus().equals("Pending"))
             {
                 assetLogDTO.setAsset_name(assetLog.getAssetName());
                 assetLogDTO.setId(assetLog.getId());
                 assetLogDTO.setLog_status(assetLog.getLogStatus());
                 assetLogDTO.setNotes(assetLog.getNotes());
                 assetLogDTO.setCandidate_name(assetLog.getCandidateName());
                 assetLogDTO.setFrom_date(assetLog.getFromDate());
                 assetLogDTO.setTo_date(assetLog.getToDate());
                 assetLogDTO.setCandidate_id(assetLog.getCandidateId());

                 list.add(assetLogDTO);
             }
        }

        return list;
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

            assetLog.setCandidateId(getUserId(userEmail));
            assetLog.setCandidateName(getUser(userEmail).get().getFirstName()+" "+getUser(userEmail).get().getLastName());
            assetLog.setLogStatus("Pending");
            assetLoggerRepository.save(assetLog);

            return true;
        } else
        {
            return false;
        }
    }

    // Admin Methods

    public boolean approveAssets(AssetLogDTO updateLog)
    {
        AssetLog assetLog = assetLoggerRepository.findById(updateLog.getId()).get();

        if(assetLog != null)
        {
            SiteUser user =  userRepository.findById(assetLog.getCandidateId()).get();
            System.out.println(user);

            assetLog.setLogStatus(updateLog.getLog_status());
            assetLoggerRepository.save(assetLog);
            return true;
        }
        else
        {
            return false;
        }
    }
}
