package cn.sunshine.test;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.junit.Test;

import cn.sunshine.util.C3p0Util;
 

 
public class TestJdbc {
 
	@Test
	public void test() {
		Connection conn=C3p0Util.getConnection();
		System.out.println(conn);
		try {
			PreparedStatement stmt=conn.prepareStatement("select * from user");
			ResultSet re=stmt.executeQuery();
			while(re.next()){
				String name=re.getString(2);
				System.out.println(name);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 
}
