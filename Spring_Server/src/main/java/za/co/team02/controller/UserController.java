package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.team02.model.SiteUser;
import za.co.team02.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
//@RequestMapping("/user") -- Removed temporarily
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
    @RequestMapping(value = "/registerUser",method = POST)
    public void addUser(@RequestBody SiteUser user) {
//        if(errors.hasErrors()){
//            log.error("Contact form validation failed due to : " + errors.toString());
//            return "contact.html";
//        }
        this.userService.addUser(user);
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
