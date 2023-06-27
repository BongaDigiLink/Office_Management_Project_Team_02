package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.team02.repository.AuthRepository;
import za.co.team02.model.SiteUser;

@Service
public class AuthService
{
    @Autowired
    private AuthRepository userDAO;

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
