package cn.sunshine.dao;


//import java.util.ArrayList;



import cn.sunshine.bean.User;

public interface UserDao {
public void addUser(User user);//ע��
public User login(User us);//��¼
//查看个人信息
public User findMy(User us);

}
