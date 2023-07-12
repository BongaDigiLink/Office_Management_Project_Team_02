package za.co.team02.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.team02.dto.DashBoardData;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.FacilityRepository;
import za.co.team02.repository.UserRepository;
import za.co.team02.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService
{
    private UserRepository userRepository;
    private FacilityRepository facilityRepository;

    public UserService(UserRepository userRepository, FacilityRepository facilityRepository) {
        this.userRepository = userRepository;
        this.facilityRepository = facilityRepository;
    }

    /**
     * If user email not unique return null.
     * @param userDto - new user transfer object, add to datastore
     * @return - the added user transfer object
     */
    public UserDTO addUser(UserDTO userDto){
        Utils utils = new Utils();
        SiteUser siteUser = new SiteUser();

        // convert DTO to entity
        siteUser.setEmail(userDto.getEmail());
        siteUser.setFirstName(userDto.getFirstName());
        siteUser.setLastName(userDto.getLastName());
        siteUser.setUsername(userDto.getUsername());
        siteUser.setPassword(utils.hashPassword("Welcome@123"));
        siteUser.setRole("user");
        siteUser.setAddress(userDto.getAddress());

        SiteUser newSiteUser = userRepository.save(siteUser);

        //convert entity to DTO
        UserDTO userResponse = new UserDTO();
        userResponse.setAdminId(newSiteUser.getId());
        userResponse.setFirstName(newSiteUser.getFirstName());
        userResponse.setLastName(newSiteUser.getLastName());
        userResponse.setUsername(newSiteUser.getUsername());
        userResponse.setPassword(utils.hashPassword(newSiteUser.getPassword()));
        userResponse.setRole(newSiteUser.getRole());
        userResponse.setAddress(newSiteUser.getAddress());
        return userResponse;
    }

    //Get none admin users
    public List<SiteUser> getUsers()
    {
        List<SiteUser> existingUsers = userRepository.getSiteUsersByRole().stream().collect(Collectors.toList());
        return  existingUsers;
    }

    public SiteUser getSingleUser(String email)
    {
        SiteUser siteUser = userRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("user with email " + email + " does not exixst"));
        return  siteUser;
    }

    public DashBoardData getDashBoardData(String userEmail)
    {
        DashBoardData data = new DashBoardData();
        SiteUser user = userRepository.findByEmail(userEmail).get();

        data.setMeetingsCount(facilityRepository.getUserMeetings(user.getId()).size());

        return data;
    }

    @Transactional
    public void updateUser(SiteUser updateUser) {
        SiteUser siteUser = userRepository.findByEmail(updateUser.getEmail()).orElseThrow(()-> new IllegalStateException("user with email "+ updateUser.getEmail()+" does not exist"));
        siteUser.setFirstName(updateUser.getFirstName());
        siteUser.setLastName(updateUser.getLastName());
        siteUser.setRole(updateUser.getRole());
        siteUser.setAddress(updateUser.getAddress());
        userRepository.save(siteUser);
    }
}
