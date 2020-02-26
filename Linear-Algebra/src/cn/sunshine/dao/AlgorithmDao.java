package cn.sunshine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.sunshine.bean.Algorithm;
//import cn.sunshine.bean.User;

//对算法文件的操作
public interface AlgorithmDao {
	/*
	 * 用户上传下载算法操作 
	 * 思路：
	 *     上传：上传到服务器后，把文件路径，文件名，上传时间，上传者的基本信息写入数据库
	 *     下载：从数据库读出所有文件的基本信息，然后根据文件名从服务器下载文件
	 *  
	 *   
	 *   1：因为并不会用类加载器，所有把用户上传下载算法仅仅做成 用户上传下载文件 
	 *   2：增加功能 
	 *       上传用户设置金币
	 *       下载需要金币，一方面下载者的金币数减少，另一方面上传者增加金币,( 前提：下载者金币数量充足)
	 */
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

	/**
	 * 管理员的操作
	 */
	// 查出所有算法地址
	public List<Algorithm> query() throws SQLException;

	// 删除某个文件地址
	public void delete(Algorithm a) throws SQLException;

}
