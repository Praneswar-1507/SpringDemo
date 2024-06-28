package com.chainsys.demoproject.DAO;
import com.chainsys.demoproject.mapper.Mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.demoproject.model.UserDetails;
@Repository
public class UserImpl implements UserDAO {
@Autowired
JdbcTemplate jdbctemplate;
public void insert(UserDetails user)
{
	String query="insert into registeredUsers(user_name,email,user_Password)values(?,?,?)";
	Object[] params= {user.getUsername(),user.getEmail(),user.getPassword()};
	int rows=jdbctemplate.update(query, params);
	System.out.println(rows);
	
}
public List<UserDetails> read()
{
	String readusers="Select * from registeredUsers where is_deleted=false";
	return jdbctemplate.query(readusers,new Mapper() );
	
}
public void delete(int id)
{
	String query="update registeredUsers  set is_deleted=true where user_ID=?";
	jdbctemplate.update(query, id);
}
public UserDetails findUser(int id)
{
	String query="Select * from registeredUsers where user_ID=?";
	return jdbctemplate.queryForObject(query,new Mapper(), id);
}
public void update(UserDetails user)
{
	String query="update registeredUsers set user_name=?,email=?,user_Password=? where user_ID=? ";
	Object[] params= {user.getUsername(),user.getEmail(),user.getPassword(),user.getUserId()};
	int rows=jdbctemplate.update(query, params);
	System.out.println(rows);
}
public List<UserDetails>search(String name)
{
	String query="select user_ID,user_name,email,user_Password from registeredUsers where user_name like ?and is_deleted=false ";
	List<UserDetails> users=jdbctemplate.query(query,new Mapper(),"%"+name+"%") ;
	return users;
	
}
}
