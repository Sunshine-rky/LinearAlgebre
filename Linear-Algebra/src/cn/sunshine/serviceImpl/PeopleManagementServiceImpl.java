package cn.sunshine.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.User;
import cn.sunshine.dao.PeopleManagementDao;
import cn.sunshine.daoImpl.PeopleManagementDaoImpl;
import cn.sunshine.service.PeopleManagementService;

public class PeopleManagementServiceImpl implements PeopleManagementService {
PeopleManagementDao pmda=new PeopleManagementDaoImpl();
	@Override
	public List<User> findAllUser() throws SQLException {
		
		return pmda.findAllUser();
	}

	@Override
	public void delect(User u) {
		pmda.delect(u);

	}

}
