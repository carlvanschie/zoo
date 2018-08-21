package com.vanschie.authenticator.controller;

import com.vanschie.authenticator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${test.value}")
    private String value;

    @RequestMapping(value = "value", method = RequestMethod.GET)
    public String getValue() {
        return value;
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User create(@RequestBody User user){
//        return userService.save(user);
//    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable(value = "id") Long id){
//        userService.delete(id);
//        return "success";
//    }

}
