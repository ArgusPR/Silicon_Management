package com.example.school.rest;

import com.example.school.entity.UserDetails;
import com.example.school.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailsRestController {
    private UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsRestController(UserDetailsService theUserDetailsService) {
        userDetailsService = theUserDetailsService;
    }

    @GetMapping("/user-details")
    public List<UserDetails> findAll() {
        return userDetailsService.findAll();
    }

    @GetMapping("/user-details/{userId}")
    public UserDetails getUser(@PathVariable int userId) {
        UserDetails theUser =userDetailsService.findById(userId);

        if(theUser == null) {
            throw new RuntimeException("User id not found : "+userId);
        }
        return theUser;
    }

    @PostMapping("/user-details")
    public UserDetails addUser(@RequestBody UserDetails theUser) {
        theUser.setUserId(0);
        userDetailsService.save(theUser);
        return theUser;
    }

    @PutMapping("/user-details")
    public UserDetails updateUser(@RequestBody UserDetails theUser) {
        userDetailsService.save(theUser);
        return theUser;
    }

    @DeleteMapping("/user-details/{userId}")
    public String deleteUser(@PathVariable int userId) {
        UserDetails tempUser = userDetailsService.findById(userId);

        if(tempUser == null) {
            throw new RuntimeException("User id not found.." + userId);
        }
        userDetailsService.deleteById(userId);
        return "Delete User id.. " +userId;
    }
}
