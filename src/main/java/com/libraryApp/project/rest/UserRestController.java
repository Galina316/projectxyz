package com.libraryApp.project.rest;

import com.libraryApp.project.entity.User;
import com.libraryApp.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController (UserService userService){this.userService=userService;}

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        if (userService.findById(id)==null)
            throw new RuntimeException("No user with "+id+" found");
        return userService.findById(id);
    }
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setId(0);
        user=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        User user= userService.findById(id);
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with this "+id);
        }else {
            userService.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted user with id "+id);
    }
}
