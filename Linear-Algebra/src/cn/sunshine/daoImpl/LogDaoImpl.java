package cn.sunshine.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.sunshine.bean.Log;
//import cn.sunshine.bean.Question;
import cn.sunshine.dao.LogDao;
import cn.sunshine.util.C3p0Util;

public class LogDaoImpl implements LogDao {
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	@Override
	public void insert(Log l) {
		// TODO Auto-generated method stub
		String sql="insert into log"+"(l_modular,u_name,u_email,l_time,l_behavior)"+"values(?,?,?,?,?)";
		try {
			qr.update(sql,l.getL_modular(),l.getU_name(),l.getU_email(),l.getL_time(),l.getL_behavior());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Log> query(Log l) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from log where l_modular=?";
		 List<Log> list= qr.query(sql, new BeanListHandler<Log>(Log.class),l.getL_modular());
		return list;
	}
	@Override
	public void clean() throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from log";
		qr.update(sql);
	}

}
