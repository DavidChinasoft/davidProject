package com.chinasoft.dao;

import java.sql.ResultSet;

import com.chinasoft.entity.User;

public interface IUserDao {

	public ResultSet  findAll();
	public ResultSet  findById(String id);
	public int updateUser(User user);
	public int delUser(User user);
	public  int addUser(User user);
}
