package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domin.User;

public interface UserMapper {

	List<User> findAll();
	
	@Update("update user set name=#{user.name},age=#{user.age},sex=#{user.sex} where id=#{user.id}")
	int update(@Param("user") User user);
	
	@Insert("insert into user(id,name,age,sex) values(#{user.id},#{user.name},#{user.age},#{user.sex})")
	int add(@Param("user") User user);
	
	@Select("select id,name,age,sex from user where id=#{id}")
	User get(@Param("id") Integer id);
	
	@Delete("delete from user where id=#{id}")
	int delete(@Param("id") Integer id);
	
}
