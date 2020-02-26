package cn.sunshine.bean;

//此bean对象对应math表
public class Algorithm {

	private String u_email;
	private String m_location;
	private String m_time;
	private String u_name;
	private String m_money;
	
	
	
	public String getU_email() {
		return u_email;
	}


	public void setU_email(String u_email) {
		this.u_email = u_email;
	}


	public String getM_location() {
		return m_location;
	}


	public void setM_location(String m_location) {
		this.m_location = m_location;
	}


	public String getM_time() {
		return m_time;
	}


	public void setM_time(String m_time) {
		this.m_time = m_time;
	}


	public String getU_name() {
		return u_name;
	}


	public void setU_name(String u_name) {
		this.u_name = u_name;
	}


	public String getM_money() {
		return m_money;
	}


	public void setM_money(String m_money) {
		this.m_money = m_money;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	private String m_name;
	

	@Override
	public String toString() {
		return "Algorithm [u_email=" + u_email + ", m_location=" + m_location + ", m_time=" + m_time + ", u_name="
				+ u_name + ", m_money=" + m_money + ", m_name=" + m_name + "]";
	}

	
}
