package com.next.java.controller;

import com.next.java.mapper.UserMapper;
import com.next.java.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloWorldController {

	private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/hello")    
    public List<User> index() {
		List<User> data =userMapper.getAll();
		
		if(data==null)
			data = new ArrayList<User>();
		
		
        return data;
		        
		//return "string";
    }
	
	@RequestMapping("/one")

	public User getOne(@RequestParam(value = "userName",required = true) String userName)
	{
		User data = userMapper.getOne(userName);
		
		if(data==null)
			data = new User();
		
		return data;
	}

	@RequestMapping("id")
	public User getUserById(@RequestParam("id") Long id){
		User data = userMapper.getOneById(id);
		if(data == null)
		{
			return new User();
		}
		log.info("id is "+id);
		return data;
	}
	
	@RequestMapping("/insert")    
	public User insert(String userName)
	{
		User data = new User();
		data.setEmail(userName+"@abc.com");
		data.setNickName(userName);
		data.setPassWord("123");
		data.setRegTime("2018-10-22");
		data.setUserName(userName);
				
		userMapper.insert(data);
		
//		if(result>0)
//			return "插入成功";
//		else return "插入失败";
		
		return data;
	}
	
	@RequestMapping("/update")    
	public String update(Long id,String userName,String nickName)
	{
		User data = new User();
		data.setId(id);
		data.setUserName(userName);
		data.setNickName(nickName);
		
		userMapper.update(data);
		return "更新成功";
	}
	
	@RequestMapping("/delete")    
	public String delete(Long id)
	{
		userMapper.delete(id);
		
		return "删除成功";
	}
}
