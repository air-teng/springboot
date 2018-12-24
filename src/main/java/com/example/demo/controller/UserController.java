package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domin.User;
import com.example.demo.myException.ServiceException;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/get/{id}")
	public String get(@PathVariable Integer id) {
		try {
			return userService.get(id).toString();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		try {
			userService.delete(id);
			return "delete success.";
		} catch (ServiceException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/add/{name}/{age}/{sex}")
	public String add(User user) {
		try {
			userService.add(user);
			return "add success.";
		}catch(ServiceException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/update/{id}/{name}/{age}/{sex}")
	public String update(User user) {
		try {
			userService.update(user);
			return "update success.";
		}catch(ServiceException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
