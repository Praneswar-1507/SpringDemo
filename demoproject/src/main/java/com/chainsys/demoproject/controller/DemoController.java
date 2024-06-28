package com.chainsys.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.demoproject.DAO.UserDAO;

import com.chainsys.demoproject.model.UserDetails;

@Controller
public class DemoController {
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("/home")
	public String home() {
		return  "home.jsp";
	}
	
@GetMapping("/welcome")
public String home(@RequestParam("username")String name,@RequestParam("email")String email,@RequestParam("password")String password, Model model)
{
	UserDetails user=new UserDetails() ;
	user.setUsername(name);
	user.setEmail(email);
	user.setPassword(password);
	System.out.println(user.getUsername()+user.getEmail());
	userdao.insert(user);
	List<UserDetails> userData=  userdao.read();
	model.addAttribute("usersData",userData);
	
	return "success.jsp";
}
@PostMapping("/delete")
public String delete(@RequestParam("deleteid")int deleteid,Model model)
{
	userdao.delete(deleteid);
	List<UserDetails> userData=  userdao.read();
	model.addAttribute("usersData",userData);
	
	return "success.jsp";
	
	
}
@PostMapping("/getuserdetails")
public String getUserDetails(@RequestParam("updateid")int updateid,Model model)
{
	UserDetails update=userdao.findUser(updateid);
	model.addAttribute("update",update);
	return "update.jsp";
	
}
@PostMapping("/update")
public String update(@RequestParam("updateid")int updateid,@RequestParam("username")String username,@RequestParam("email")String email,@RequestParam("password")String password,Model model)
{
	UserDetails user=new UserDetails() ;
	user.setUserId(updateid);
	user.setUsername(username);
	user.setEmail(email);
	user.setPassword(password);
	userdao.update(user);
	List<UserDetails> userData=  userdao.read();
	model.addAttribute("usersData",userData);
	return "success.jsp";
	
}
@PostMapping("search")
public String search(@RequestParam("search")String name,Model model)
{
	List<UserDetails> userData=userdao.search(name);
	model.addAttribute("usersData",userData);
	return "success.jsp";
	
}


}
