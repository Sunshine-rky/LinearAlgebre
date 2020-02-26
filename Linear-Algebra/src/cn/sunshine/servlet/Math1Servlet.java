package cn.sunshine.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sunshine.bean.Log;
import cn.sunshine.service.LogService;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.util.MathUtil;

@WebServlet("/Math1Servlet")
public class Math1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		String name = request.getParameter("a");
        System.out.println(name.length());
		name = name.substring(0, name.length() - 3);
		//System.out.println(name.length());
		//如果用户没填数据,提醒用户填入数据
		if (name.length() == 0) {
			String err = "  请填入数据";
			mapper.writeValue(response.getWriter(), err);
		} 
		else {
			double[][] arr = MathUtil.arryParser(name);

			// 如果用户未填写符合规定的数据,提醒用户填入符合规定的数据
			if (arr == null) {
				String err = "  请填入符合规定的数据";
				mapper.writeValue(response.getWriter(), err);
			} else {
				double a = MathUtil.fun(arr);
//				System.out.println(a);
				mapper.writeValue(response.getWriter(), a);
			}

	}
		//存入日志中
				Log log=new Log();
				 Date now = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String l_time= simpleDateFormat.format(now);
					
					String u_email=(String)request.getSession().getAttribute("email");
					String u_name=(String)request.getSession().getAttribute("name");
					System.out.println(u_email+"cdvfg1235");
					System.out.println(u_name+"cdvfg1235");
					log.setL_time(l_time);
					log.setU_email(u_email);
					log.setU_name(u_name);
					log.setL_behavior("行列式求值");
					log.setL_modular("运算模块");
					LogService ls=new LogServiceImpl();
					ls.add(log);
				
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
