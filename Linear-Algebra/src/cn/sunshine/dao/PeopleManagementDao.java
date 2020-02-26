package cn.sunshine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.User;

public interface PeopleManagementDao {

	//管理员查出所有用户的基本信息
	public   List<User> findAllUser() throws SQLException;
	
	//管理员删除学生(删除非法用户.比如名字涉及黄暴,非法积累金币)
	public void delect(User u);
}
