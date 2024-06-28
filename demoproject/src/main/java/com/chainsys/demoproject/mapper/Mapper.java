package com.chainsys.demoproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.demoproject.model.UserDetails;

public class Mapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails user = new UserDetails();
		user.setUserId(rs.getInt("user_ID"));
		user.setUsername(rs.getString("user_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("user_Password"));
		return user;
	}

}
