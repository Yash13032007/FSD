package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	    @Autowired
	    private UserService userService;

	    // Save User
	    @PostMapping("/save")
	    public UserModel saveUser(@RequestBody UserModel user) 
		{
	        return userService.saveUser(user);
	    }

	    // Get All Users
	    @GetMapping("/getallUsers")
	    public List<UserModel> getAllUsers() 
		{
	        return userService.getAllUsers();
	    }

	    // Update by ID
	    @PutMapping("/updateById/{id}")
	    public UserModel updateById(@PathVariable String id, @RequestBody UserModel user) 
		{
	        return userService.updateById(id, user);
	    }

	    // Update by Name
	    @PutMapping("/updateByName/{name}")
	    public UserModel updateByName(@PathVariable String name, @RequestBody UserModel user) 
		{
	        return userService.updateByName(name, user);
	    }

	    // Delete by ID
	    @DeleteMapping("/deleteById/{id}")
	    public String deleteById(@PathVariable String id) 
		{
	        userService.deleteById(id);
	        return "User deleted with id: " + id;
	    }

	    // Delete by Name
	    @DeleteMapping("/deleteByName/{name}")
	    public String deleteByName(@PathVariable String name) 
		{
	        userService.deleteByName(name);
	        return "User deleted with name: " + name;
	    }
	}

