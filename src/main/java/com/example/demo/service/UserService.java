package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domin.User;
import com.example.demo.myException.ServiceException;

public interface UserService {
	
	/**
	 * 查询所有的user信息
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 修改user信息
	 * @param user
	 * @throws ServiceException
	 */
	void update(User user) throws ServiceException;
	
	/**
	 * 添加一条user记录
	 * @param user
	 * @throws ServiceException
	 */
	void add(User user) throws ServiceException;
	
	/**
	 * 根据id查询一条user信息
	 * @param id
	 * @return
	 */
	User get(Integer id) throws ServiceException;
	
	/**
	 * 根据id删除一条user信息
	 * @param id
	 * @throws ServiceException
	 */
	void delete(@PathVariable Integer id) throws ServiceException;

}
