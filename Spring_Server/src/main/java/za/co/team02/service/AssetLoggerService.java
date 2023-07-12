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
                 assetLogDTO.setAssetName(assetLog.getAssetName());
                 assetLogDTO.setId(assetLog.getId());
                 assetLogDTO.setLogStatus(assetLog.getLogStatus());
                 assetLogDTO.setNotes(assetLog.getNotes());
                 assetLogDTO.setCandidateName(assetLog.getCandidateName());
                 assetLogDTO.setFromDate(assetLog.getFromDate());
                 assetLogDTO.setToDate(assetLog.getToDate());
                 assetLogDTO.setCandidateId(assetLog.getCandidateId());
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
        Optional<SiteUser> user = userRepository.findByEmail(userEmail);
        if(assetLog ==null) return false;
        assetLog.setCandidateId(getUserId(userEmail));
        assetLog.setCandidateName(user.get().getFirstName()+" "+getUser(userEmail).get().getLastName());
        assetLog.setAssetName(assetLog.getAssetName());
        assetLog.setFromDate(assetLog.getFromDate());
        assetLog.setToDate(assetLog.getToDate());
        assetLog.setLogStatus("Pending");
        assetLog.setNotes(assetLog.getNotes());
        assetLog.setReason(assetLog.getReason());
        assetLoggerRepository.save(assetLog);
        return true;
    }

    // Admin Methods

    public boolean approveAssets(AssetLogDTO updateLog)
    {
        AssetLog assetLog = assetLoggerRepository.findById(updateLog.getId()).get();

        if(assetLog != null)
        {
            SiteUser user =  userRepository.findById(assetLog.getCandidateId()).get();
            System.out.println(user);

            assetLog.setLogStatus(updateLog.getLogStatus());
            assetLoggerRepository.save(assetLog);
            return true;
        }
        else
        {
            return false;
        }
    }
}
