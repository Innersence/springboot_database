package com.next.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.next.model.User;;

public interface UserMapper {
	@Select("select * from user")
	@Results({
		@Result(property="userName",column="user_name"),
		@Result(property="email",column="email")
	})
	List<User> getAll();
	
	@Select("select * from user where user_name=#{userName}")
	@Results({
		@Result(property="userName",column="user_name"),
		@Result(property="email",column="email")
	})
	User getOne(String userName);

	@Select("select * from user where id=#{id}")
	@Results({
			@Result(property="userName",column="user_name"),
			@Result(property="email",column="email")
	})
	User getOneById(Long id);
	
	@Insert("insert into user(id,email,nick_name,pass_word,reg_time,remark,user_name) values(#{id},#{email},#{nickName},#{passWord},#{regTime},#{remark},#{userName})")
	void insert(User data);
	
	@Update("update user set user_name=#{userName},nick_name=#{nickName} where id=#{id}")
	void update(User data);
	
	@Delete("delete from user where id=#{id}")
	void delete(Long id);
}
