package cn.sunshine.serviceImpl;



import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.User;
import cn.sunshine.dao.UserDao;
import cn.sunshine.daoImpl.UseDaoImpl;
import cn.sunshine.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao=new UseDaoImpl();
	@Override
	public void register(User user) {
		userDao.addUser(user);
	}
	@Override
	public User login(User us) {
		// TODO Auto-generated method stub
		System.out.println(userDao.login(us));
		return userDao.login(us);
	}
	@Override
	public User findMy(User us) {
		// TODO Auto-generated method stub
		return userDao.findMy(us);
	}
	

}
