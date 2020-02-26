package cn.sunshine.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.sunshine.bean.User;
import cn.sunshine.dao.PeopleManagementDao;
import cn.sunshine.util.C3p0Util;

public class PeopleManagementDaoImpl implements PeopleManagementDao{
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	@Override
	public List<User> findAllUser() throws SQLException {
		String sql="select * from user where u_role='user'";
		 List<User> list= qr.query(sql, new BeanListHandler<User>(User.class));
		return list;
		
	}

	@Override
	public void delect(User u) {
     String sql="delete from user where u_email=?";
     try {
		qr.update(sql,u.getU_email());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
