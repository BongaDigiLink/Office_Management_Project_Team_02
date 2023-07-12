package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;
import za.co.team02.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        siteUser.setFirst_Name(userDto.getFirst_Name());
        siteUser.setLastName(userDto.getLastName());
        siteUser.setUsername(userDto.getUsername());
        siteUser.setEmail(userDto.getEmail());
        siteUser.setPassword(utils.hashPassword("Welcome@123"));
        siteUser.setAddress(userDto.getAddress());
        siteUser.setRole("user");

        System.out.println(siteUser);
        SiteUser newSiteUser = userRepository.save(siteUser);


        //convert entity to DTO
        UserDTO userResponse = new UserDTO();
        //userResponse.setAdmin_Id(newSiteUser.getUser_id());
        userResponse.setFirst_Name(newSiteUser.getFirst_Name());
        userResponse.setLastName(newSiteUser.getLastName());
        userResponse.setUsername(newSiteUser.getUsername());
        userResponse.setPassword(utils.hashPassword(newSiteUser.getPassword()));
        userResponse.setEmail(newSiteUser.getEmail());
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
        SiteUser siteUser =userRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("user with email " + email + " does not exixst"));
        return  siteUser;
    }

    public void updateUser(SiteUser updateUser)
    {
        SiteUser siteUser = userRepository.findByEmail(updateUser.getEmail()).orElseThrow(()-> new IllegalStateException("user with email "+ updateUser.getEmail()+" does not exist"));
//        SiteUser siteUser = getSingleUser(updateUser.getEmail());
        siteUser.setFirst_Name(updateUser.getFirst_Name());
        siteUser.setLastName(updateUser.getLastName());
        siteUser.setRole(updateUser.getRole());
        siteUser.setAddress(updateUser.getAddress());
        userRepository.save(siteUser);
    }
}
