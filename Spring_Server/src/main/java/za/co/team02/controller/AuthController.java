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

@RestController
@RequestMapping(path = "/auth")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<SiteUser> loginUser(@RequestBody LoginDetails loginDetails)
    {
        //System.out.println("Test Login Post:"+loginDetails.getEmail() +" psswd:"+loginDetails.getPassword());
        if(this.authService.checkUser(loginDetails.getEmail()))
        {
            if(this.authService.getUserByEmail(loginDetails.getEmail()) != null
                    && this.authService.getUserByEmail(loginDetails.getEmail())
                    .getPassword()
                    .equals(loginDetails.getPassword()))
            {
                return new ResponseEntity<>(this.authService.getUserByEmail(loginDetails.getEmail()),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
