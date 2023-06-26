package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.team02.dao.UserDAO;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    /**
     * If user email not unique return null.
     * @param newUser - new user object, add to datastore
     * @return - the added user object
     */
    public boolean addUser(SiteUser newUser) {
        boolean isSaved = false;
        int result = userRepository.saveUser(newUser);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }

}
