package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        userResponse.setEmail(newSiteUser.getEmail());
        userResponse.setFirstName(newSiteUser.getFirstName());
        userResponse.setLastName(newSiteUser.getLastName());
        userResponse.setUsername(newSiteUser.getUsername());
        userResponse.setPassword(newSiteUser.getPassword());
        userResponse.setRole(newSiteUser.getRole());
        userResponse.setAddress(newSiteUser.getAddress());
        return userResponse;
    }

    @Transactional
    public void updateStudent(Integer userId,
                              String email,
                              String firstName,
                              String lastName,
                              String username,
                              String password,
                              String role,
                              String address){
        SiteUser siteUser = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("student with id "+ userId+" does not exixst"));

        if(firstName != null && lastName != null && username !=null &&  password !=null && role != null && address!=null &&
                !Objects.equals(siteUser.getFirstName(),firstName)){
            siteUser.setFirstName(siteUser.getFirstName());
        }

        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(siteUser.getEmail(),email)){
            Optional<SiteUser> studentOptional = userRepository.findStudentByEmail(email);

            if(studentOptional.isPresent())
            {
                throw new IllegalStateException(("email taken"));
            }
            siteUser.setEmail(siteUser.getEmail());
        }
        userRepository.save(siteUser);
    }

    public List<SiteUser> getUsers()
    {
        return userRepository.findAll();
    }
}
