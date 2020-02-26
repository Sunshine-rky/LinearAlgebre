package cn.sunshine.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.User;
import cn.sunshine.dao.AlgorithmDao;
import cn.sunshine.util.C3p0Util;

public class AlgorithmDaoImpl implements AlgorithmDao {
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	@Override
	public List<Algorithm> query() throws SQLException {
		String sql="select m_location from math";
		List<Algorithm> list=qr.query(sql, new BeanListHandler<Algorithm>(Algorithm.class));
		return list;
	}

	@Override
	public void delete(Algorithm a) throws SQLException {
		String sql="delete from math where m_location=?";
		qr.update(sql,a.getM_location());
		
	}
	@Override
	public void addAlgorithm(Algorithm a) {
		// TODO Auto-generated method stub
	
		String sql="insert into math "+"(u_email,m_location,u_name,m_time,m_money,m_name)"+"values(?,?,?,?,?,?)";
		try {
			qr.update(sql,a.getU_email(),a.getM_location(),a.getU_name(),a.getM_time(),a.getM_money(),a.getM_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Algorithm> download() throws SQLException {
		String sql=" select * from math ";
		 List<Algorithm> list= qr.query(sql, new BeanListHandler<Algorithm>(Algorithm.class));
	System.out.println(list+"hahahah");
	return list;
	
	
	}

	@Override
	public void subMoney(Algorithm a) {
		// TODO Auto-generated method stub
		String sql="UPDATE user SET u_money=u_money-? WHERE u_email=?";
		try {
			qr.update(sql,a.getM_money(),a.getU_email());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addMoney(Algorithm a) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String sql="UPDATE user SET u_money=u_money+? WHERE u_email in (SELECT u_email FROM math WHERE  m_name=?)";
				try {
					qr.update(sql,a.getM_money(),a.getM_name());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
