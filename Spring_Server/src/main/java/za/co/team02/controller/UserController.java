package za.co.team02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import za.co.team02.dto.UserDTO;
import za.co.team02.model.SiteUser;
import za.co.team02.service.UserService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/user")
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
    public String addUser(@RequestBody UserDTO userDto,Errors errors) {
        if(errors.hasErrors()){
            System.out.println("Contact form validation failed due to : " + errors.toString());
            return "user.component.html";
        }

        this.userService.addUser(userDto);
        return "redirect:/contact";
    }

    /**
     * admin
     * controller - view all users
     */

    @GetMapping("/all-users")
    public List<SiteUser> getStudents()
    {
        return userService.getUsers();
    }

    /**
     * admin
     * controller - edit a user (CRUD)
     */

//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @PathVariable(required = false) String name,
//            @PathVariable(required = false) String email){
//        userService.updateStudent(studentId,name,email);
//    }

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
