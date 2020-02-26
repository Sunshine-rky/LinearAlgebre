package cn.sunshine.daoImpl;

import java.sql.SQLException;
//import java.util.ArrayList;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.sunshine.bean.User;
import cn.sunshine.dao.UserDao;
//import cn.sunshine.util.C3P0Utils;
import cn.sunshine.util.C3p0Util;

public class UseDaoImpl implements UserDao {
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	@Override
	public void addUser(User user) {
	
		String sql="insert into user"+"(u_name,u_password,u_email,u_registertime)"+"values(?,?,?,?)";
		try {
			qr.update(sql,user.getU_name(),user.getU_password(),user.getU_email(),user.getU_registertime());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User login(User us) {
	
		String sql="select * from user where u_email =? and u_name=? and u_password =?";
		//String sql1="select u_role  from user where u_email =? and u_password =?";
		try {
			
			//System.out.println();
			return qr.query(sql,new BeanHandler<User>(User.class),us.getU_email(),us.getU_name(),us.getU_password());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findMy(User us) {
		String sql="select * from user where u_email =?";
		//String sql1="select u_role  from user where u_email =? and u_password =?";
		try {
			
			//System.out.println();
			return qr.query(sql,new BeanHandler<User>(User.class),us.getU_email());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	

}
