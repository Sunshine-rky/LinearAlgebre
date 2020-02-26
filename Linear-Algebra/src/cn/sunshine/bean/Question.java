package cn.sunshine.bean;

public class Question {
private String u_email;
private String u_name;
private String q_title;
private String q_time;
private String q_money;
private String q_state;
private String q_content;
private String a_number;
public String getA_number() {
	return a_number;
}

public void setA_number(String a_number) {
	this.a_number = a_number;
}

public String getU_email() {
	return u_email;
}

@Override
public String toString() {
	return "Question [u_email=" + u_email + ", u_name=" + u_name + ", q_title=" + q_title + ", q_time=" + q_time
			+ ", q_money=" + q_money + ", q_state=" + q_state + ", q_content=" + q_content + ", a_number=" + a_number
			+ "]";
}

public void setU_email(String u_email) {
	this.u_email = u_email;
}

public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getQ_title() {
	return q_title;
}
public void setQ_title(String q_title) {
	this.q_title = q_title;
}
public String getQ_time() {
	return q_time;
}
public void setQ_time(String q_time) {
	this.q_time = q_time;
}
public String getQ_money() {
	return q_money;
}
public void setQ_money(String q_money) {
	this.q_money = q_money;
}
public String getQ_state() {
	return q_state;
}
public void setQ_state(String q_state) {
	this.q_state = q_state;
}
public String getQ_content() {
	return q_content;
}
public void setQ_content(String q_content) {
	this.q_content = q_content;
}

}
