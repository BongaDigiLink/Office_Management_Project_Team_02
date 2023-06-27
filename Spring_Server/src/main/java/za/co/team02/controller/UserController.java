package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.UserDTO;
import za.co.team02.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/register")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * admin
     * controller - add user
     */
//    @RequestMapping(value = "/registerUser",method = POST)
    @PostMapping
    public void addUser(@RequestBody UserDTO userDto) {
//        if(errors.hasErrors()){
//            log.error("Contact form validation failed due to : " + errors.toString());
//            return "contact.html";
//        }

        this.userService.addUser(userDto);
//        return "redirect:/contact";
    }

    /**
     * admin
     * controller - view all users
     */

    /**
     * admin
     * controller - edit a user (CRUD)
     */

    /**
     * admin
     * controller - update food reserve
     */

    /**
     * Admin
     * controller - view all assets
     */

    /**
     * Admin
     * controller - manage an asset
     */

    /**
     * user
     * controller - update details
     */

    /**
     * user
     * controller - make  meeting booking
     */

    /**
     * user
     * controller -  complete a register
     */

    /**
     * user
     * controller - request food
     */

}
