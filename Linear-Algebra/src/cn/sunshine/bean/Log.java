package cn.sunshine.bean;

public class Log {
private String l_modular;
private String u_name;
private String u_email;
private String l_time;
private String l_behavior;
@Override
public String toString() {
	return "Log [l_modular=" + l_modular + ", u_name=" + u_name + ", u_email=" + u_email + ", l_time=" + l_time
			+ ", l_behavior=" + l_behavior + "]";
}
public String getL_modular() {
	return l_modular;
}
public void setL_modular(String l_modular) {
	this.l_modular = l_modular;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_email() {
	return u_email;
}
public void setU_email(String u_email) {
	this.u_email = u_email;
}
public String getL_time() {
	return l_time;
}
public void setL_time(String l_time) {
	this.l_time = l_time;
}
public String getL_behavior() {
	return l_behavior;
}
public void setL_behavior(String l_behavior) {
	this.l_behavior = l_behavior;
} 
}
