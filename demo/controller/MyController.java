package com.example.demo.controller;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class MyController {
	
	/*@RequestMapping("")
	public ResponseEntity<String> hai()
	{
		return new ResponseEntity<String>("Hello ",HttpStatus.OK);
	}*/
/*	
	 @RequestMapping("/test")
	   public Map<String,Object> test(){
		   Map<String,Object> map = new LinkedHashMap<>();
		   map.put("Age","22");
		   return map;
	 }
*/
	@Autowired
	UserService userService;
	@ResponseBody
	@RequestMapping("")
	public List<User> getAllUsers(){

		/*Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", "Get All Users Implementation");
		return map;*/
	return userService.getAllUsers();
	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.getUser(3);
	}
	public Map<String, Object>  getAllUser(@PathVariable("id") Integer id){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", "Get User Implementation based on id");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="",method = RequestMethod.POST)
	public Map<String, Object>  createUser(@RequestParam(value="userid")
	Integer userid, @RequestParam(value="username")String username){
		Map<String, Object> map = new LinkedHashMap<>();
		userService.createUser(userid, username);
		map.put("result", "create Users Implementation");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.PUT)
	public Map<String, Object>  updateUser(@RequestParam(value="userid")
	Integer userid, @RequestParam(value="username")String username){
		Map<String, Object> map = new LinkedHashMap<>();
		userService.updateUser(userid, username);
		map.put("result", "Update User Implementation");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public Map<String, Object>  deleteUser(@PathVariable("id") Integer userid){
		Map<String, Object> map = new LinkedHashMap<>();
		userService.deleteUser(userid);
		map.put("result", "Delete User Implementation");
		return map;
	}
	
}
