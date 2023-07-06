package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.team02.model.SiteUser;
import za.co.team02.service.AuthService;
import za.co.team02.dto.LoginDetails;
import za.co.team02.utils.Utils;

@RestController
@RequestMapping(path = "/auth")
public class AuthController
{
    private AuthService authService;
    private Utils utils = new Utils();

    @Autowired
    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    /**
     * @param loginDetails - from login page
     * @return - user object if user exists
     */
    @PostMapping("/login")
    public ResponseEntity<SiteUser> loginUser(@RequestBody LoginDetails loginDetails)
    {
        if(this.authService.getUserByEmail(loginDetails.getEmail()) != null)
        {
            if(utils.checkPasswords(loginDetails.getPassword(), this.authService.getUserByEmail(loginDetails.getEmail())))
            {
                return new ResponseEntity<>(this.authService.getUserByEmail(loginDetails.getEmail()),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
