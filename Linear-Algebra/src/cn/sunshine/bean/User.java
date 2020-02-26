package cn.sunshine.bean;

public class User {
	private String u_name;
	private String u_password;

	private String u_email;

	private String u_role;
	private String u_registertime;
	private String u_money;

	public String getU_name() {
		return u_name;
	}

	@Override
	public String toString() {
		return "User [u_name=" + u_name + ", u_password=" + u_password + ", u_email=" + u_email + ", u_role=" + u_role
				+ ", u_registertime=" + u_registertime + ", u_money=" + u_money + "]";
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_role() {
		return u_role;
	}

	public void setU_role(String u_role) {
		this.u_role = u_role;
	}

	public String getU_registertime() {
		return u_registertime;
	}

	public void setU_registertime(String u_registertime) {
		this.u_registertime = u_registertime;
	}

	public String getU_money() {
		return u_money;
	}

	public void setU_money(String u_money) {
		this.u_money = u_money;
	}

}
