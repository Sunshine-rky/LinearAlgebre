package cn.sunshine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Log;

public interface LogDao {
//将用户所有的操作加入日志表中
public void insert(Log l);

//按不同的模块查看日志
public List<Log> query(Log l) throws SQLException;

//清空日志
public void clean() throws SQLException;



}
