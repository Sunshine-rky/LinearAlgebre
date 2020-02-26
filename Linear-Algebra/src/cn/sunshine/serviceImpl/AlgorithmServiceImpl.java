package cn.sunshine.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.User;
import cn.sunshine.dao.AlgorithmDao;
import cn.sunshine.daoImpl.AlgorithmDaoImpl;
import cn.sunshine.service.AlgorithmService;

public class AlgorithmServiceImpl implements AlgorithmService {
AlgorithmDao ad=new AlgorithmDaoImpl();
	@Override
	public List<Algorithm> query() throws SQLException {
		
		return ad.query();
	}

	@Override
	public void delete(Algorithm a) throws SQLException {
	ad.delete(a);
	}

	@Override
	public void addAlgorithm(Algorithm a) {
		ad.addAlgorithm(a);
	}

	@Override
	public List<Algorithm> download() throws SQLException {
		// TODO Auto-generated method stub
		return ad.download();
	}

	@Override
	public void subMoney(Algorithm a) {
		// TODO Auto-generated method stub
		ad.subMoney(a);
	}

	@Override
	public void addMoney(Algorithm a) {
		// TODO Auto-generated method stub
		ad.addMoney(a);
	}

}
