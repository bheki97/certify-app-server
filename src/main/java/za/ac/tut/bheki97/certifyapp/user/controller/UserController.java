package za.ac.tut.bheki97.certifyapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.tut.bheki97.certifyapp.user.User;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;
import za.ac.tut.bheki97.certifyapp.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean create(@RequestBody User user) throws UserException {
        return userService.registerUser(user);
    }


    @GetMapping
    public List<User> read(){
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public User readById(@PathVariable String email){
        return userService.getUserByEmail(email);
    }


    @PostMapping("/update")
    public boolean update(@RequestBody User user) throws UserException {

        return userService.updateAccount(user);
    }

    @DeleteMapping("/{email}")
    public boolean deactivate(@PathVariable String email){
        return userService.deActivateAcc(email);
    }




}
