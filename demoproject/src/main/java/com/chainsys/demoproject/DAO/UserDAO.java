package com.chainsys.demoproject.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.demoproject.model.UserDetails;

@Repository
public interface UserDAO {
	public void insert(UserDetails user);
	public List<UserDetails> read();
	public void delete(int id);
	public UserDetails findUser(int id);
	public void update(UserDetails user);
	public List<UserDetails>search(String name);
}
