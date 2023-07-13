package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.AssetLogDTO;
import za.co.team02.dto.EventDTO;
import za.co.team02.model.Asset;
import za.co.team02.model.AssetLog;
import za.co.team02.model.Event;
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

    public AssetLogDTO createNewAssetLog(String userEmail, AssetLogDTO assetLogDTO)
    {
        Optional<SiteUser> user = userRepository.findByEmail(userEmail);
        AssetLog assetLog = new AssetLog();

        assetLog.setCandidateId(getUserId(userEmail));
        assetLog.setCandidateName(user.get().getFirstName()+" "+getUser(userEmail).get().getLastName());
        assetLog.setAssetName(assetLogDTO.getAssetName());
        assetLog.setFromDate(assetLogDTO.getFromDate());
        assetLog.setToDate(assetLogDTO.getToDate());
        assetLog.setLogStatus("Pending");
        assetLog.setNotes(assetLogDTO.getNotes());
        assetLog.setReason(assetLogDTO.getReason());

        AssetLog newAssetLog = assetLoggerRepository.save(assetLog);

        AssetLogDTO logResponse = new AssetLogDTO();
        logResponse.setCandidateId(newAssetLog.getCandidateId());
        logResponse.setAssetName(newAssetLog.getAssetName());
        logResponse.setFromDate(newAssetLog.getFromDate());
        logResponse.setToDate(newAssetLog.getToDate());
        logResponse.setLogStatus(newAssetLog.getLogStatus());
        logResponse.setNotes(newAssetLog.getNotes());
        logResponse.setReason(newAssetLog.getReason());
        return logResponse;
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
