package cn.sunshine.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Log;
import cn.sunshine.dao.LogDao;
import cn.sunshine.daoImpl.LogDaoImpl;
import cn.sunshine.service.LogService;

public class LogServiceImpl implements LogService {
LogDao ld=new LogDaoImpl();
	@Override
	public void add(Log l) {
		// TODO Auto-generated method stub
  ld.insert(l);
	}
	@Override
	public List<Log> query(Log l) throws SQLException {
		
		return ld.query(l);
	}
	@Override
	public void clean() throws SQLException {
		// TODO Auto-generated method stub
		ld.clean();
	}

}
