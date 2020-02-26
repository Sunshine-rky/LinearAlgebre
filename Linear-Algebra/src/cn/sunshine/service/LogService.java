package cn.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Log;

public interface LogService {
//将所有的操作放入log表中
	public void add(Log l);
	
	//按不同的模块查看日志
	public List<Log> query(Log l) throws SQLException;

	//清空日志
	public void clean() throws SQLException;
}
