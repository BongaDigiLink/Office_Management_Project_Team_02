package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import za.co.team02.dao.UserDAO;
import za.co.team02.model.SiteUser;

@Service
public class AuthService
{
    @Autowired
    private UserDAO userDAO;

    public SiteUser loginUser(String userEmail, String userPassword)
    {

        return null;
    }

    public SiteUser getUserByEmail(String email)
    {
        return this.userDAO.findByEmail(email);
    }

    public boolean checkUser(String email)
    {
        return this.userDAO.existsByEmail(email);
    }
}
