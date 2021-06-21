package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
@Service
public class UserServiceImpl implements UserService {
    public List<User> users;
	@Override
	public List<User> getAllUsers() {
		
		return this.users;
	}
	
	public UserServiceImpl() {
	users = new LinkedList<>();
	users.add(new User(1,"messi"));
	users.add(new User(2,"suarez"));
	users.add(new User(3,"neymar"));
	users.add(new User(4,"mbappe"));
	
	}
	@Override
	public  User getUser(Integer userid) {
		return users.stream().filter(x -> x.getUserid()== userid)
				.findAny().orElse(new User(0, "not available"));
	}
	@Override
	public void createUser(Integer userid, String username) {
		User user = new User(userid, username);
		this.users.add(user);
	}

	@Override
	public void updateUser(Integer userid, String username) {
		users.stream().filter(x->x.getUserid()==userid).findAny()
		.orElseThrow(()->new RuntimeException("item not found"))
		.setUsername(username);
	}

	@Override
	public void deleteUser(Integer userid) {
		users.removeIf((User u)->u.getUserid()==userid);
	}
	

}