package cn.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.User;

public interface AlgorithmService {

	//查出所有算法地址
		public List<Algorithm> query() throws SQLException;
		//删除某个文件地址
		public void delete(Algorithm a) throws SQLException;
		
		
		public void addAlgorithm(Algorithm a);// 用户上传
		/*
		 * 用户下载
		 * 
		 */
		// 拿到上传的文件信息

		public List<Algorithm> download() throws SQLException;

		// 下载者的金币数减少
		public void subMoney(Algorithm a);

		// 上传者增加金币

		public void addMoney(Algorithm a);

}
