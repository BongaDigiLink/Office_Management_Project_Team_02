package za.co.team02.service;

import org.springframework.stereotype.Service;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;

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
        SiteUser siteUser = new SiteUser();

        // convert DTO to entity
        siteUser.setEmail(userDto.getEmail());
        siteUser.setFirstName(userDto.getFirstName());
        siteUser.setLastName(userDto.getLastName());
        siteUser.setUsername(userDto.getUsername());
        siteUser.setPassword(userDto.getPassword());
        siteUser.setRole(userDto.getRole());
        siteUser.setAddress(userDto.getAddress());

        SiteUser newSiteUser = userRepository.save(siteUser);

        //convert entity to DTO
        UserDTO userResponse = new UserDTO();
        userResponse.setAdminId(newSiteUser.getAdminId());
        userResponse.setFirstName(newSiteUser.getFirstName());
        userResponse.setLastName(newSiteUser.getLastName());
        userResponse.setUsername(newSiteUser.getUsername());
        userResponse.setPassword(newSiteUser.getPassword());
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

    public void updateUser(SiteUser updateUser) {
        SiteUser siteUser = userRepository.findUserByEmail(updateUser.getEmail()).orElseThrow(()-> new IllegalStateException("user with email "+ updateUser.getEmail()+" does not exixst"));
        siteUser.setFirstName(updateUser.getFirstName());
        siteUser.setLastName(updateUser.getLastName());
        siteUser.setRole(updateUser.getRole());
        siteUser.setAddress(updateUser.getAddress());
        userRepository.save(siteUser);
    }
}
