package za.co.team02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.team02.repository.AuthRepository;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.UserRepository;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userDAO;

    public AuthService(UserRepository authRepository)
    {this.userDAO = authRepository;}

    public SiteUser getUserByEmail(String email)
    {
        return this.userDAO.findByEmail(email).get();
    }
}
