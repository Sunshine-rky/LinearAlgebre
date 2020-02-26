package cn.sunshine.bean;

public class Answer {
private String u_email;
private String u_name;
private String a_content;
private String a_time;
private String q_title;


@Override
public String toString() {
	return "Answer [u_email=" + u_email + ", u_name=" + u_name + ", a_content=" + a_content + ", a_time=" + a_time
			+ ", q_title=" + q_title + "]";
}
public String getU_email() {
	return u_email;
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
public String getA_content() {
	return a_content;
}
public void setA_content(String a_content) {
	this.a_content = a_content;
}
public String getA_time() {
	return a_time;
}
public void setA_time(String a_time) {
	this.a_time = a_time;
}
public String getQ_title() {
	return q_title;
}
public void setQ_title(String q_title) {
	this.q_title = q_title;
}

}
