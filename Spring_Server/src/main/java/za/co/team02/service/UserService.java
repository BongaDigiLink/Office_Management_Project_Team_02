package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.team02.dao.UserDAO;
import za.co.team02.model.SiteUser;

public class UserService
{

    @Autowired
    private UserDAO userDAO;

    /**
     * If user email not unique return null.
     * @param newUser - new user object, add to datastore
     * @return - the added user object
     */
    public SiteUser addUser(SiteUser newUser)
    {
        if(userDAO.existsByEmail(newUser.getEmail()))
        {
            return null;
        }
        return userDAO.save(newUser);
    }

}
