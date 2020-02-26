package cn.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.User;

public interface UserService {
	
public void register(User user);

public User login(User us);

//查看个人信息
public User findMy(User us);

}
