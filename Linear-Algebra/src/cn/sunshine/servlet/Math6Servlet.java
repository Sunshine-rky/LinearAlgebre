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

/**
 * Servlet implementation class Math6Servlet
 */
@WebServlet("/Math6Servlet")
public class Math6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper=new ObjectMapper();
		String a = request.getParameter("a");
		a= a.substring(0, a.length() - 3);
		//System.out.println(name.length());
		//如果用户没填数据,提醒用户填入数据
		if (a.length() == 0) {
			String err = "  请填入数据";
			mapper.writeValue(response.getWriter(), err);
		} 
		else {
			double[][] arr = MathUtil.arryParser1(a);

			// 如果用户未填写符合规定的数据,提醒用户填入符合规定的数据
			if (arr == null) {
				String err = "  请填入符合规定的数据";
				mapper.writeValue(response.getWriter(), err);
			} else if(arr.length>arr[0].length){
				String err="   矩阵的行数不应该大于列数";
				mapper.writeValue(response.getWriter(), err);
			}else {
				
				int d=MathUtil.Rank(arr, -1, arr.length);
				
				mapper.writeValue(response.getWriter(), "矩阵的秩为"+d);
			}

		}
		
		//存入日志中
  		Log log=new Log();
  		 Date now = new Date();
  			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  			String l_time= simpleDateFormat.format(now);
  			
  			String u_email=(String)request.getSession().getAttribute("email");
  			String u_name=(String)request.getSession().getAttribute("name");
  			log.setL_time(l_time);
  			log.setU_email(u_email);
  			log.setU_name(u_name);
  			log.setL_behavior("求矩阵的秩");
  			log.setL_modular("运算模块");
  			LogService ls=new LogServiceImpl();
  			ls.add(log);		
				
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
