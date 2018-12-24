package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domin.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.myException.ServiceException;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public void update(User user) throws ServiceException {
		int upRes=userMapper.update(user);
		if(upRes<1) {
			throw new ServiceException("update failed.");
		}
	}

	@Override
	public void add(User user) throws ServiceException {
		Integer newId=Integer.parseInt(Long.toString(System.currentTimeMillis()).substring(7));
		user.setId(newId);
		int addRes=userMapper.add(user);
		if(addRes<1) {
			throw new ServiceException("add failed.");
		}
		
	}

	@Override
	public User get(Integer id) throws ServiceException {
		User user= userMapper.get(id);
		if(user==null) {
			throw new ServiceException("查询不到此条记录");
		}
		return user;
	}
	
	public void delete(Integer id) throws ServiceException{
		int delRes=userMapper.delete(id);
		if(delRes<1) {
			throw new ServiceException("delete failed.");
		}
	}
}
