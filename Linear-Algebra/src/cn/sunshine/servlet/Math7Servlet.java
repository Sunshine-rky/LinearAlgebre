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
 * Servlet implementation class Math7Servlet
 */
@WebServlet("/Math7Servlet")
public class Math7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//根据定理,向量线性相关的必要条件是秩小于向量个数,不相关的充分必要条件是秩等于向量的个数
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper=new ObjectMapper();
		String a=request.getParameter("a");
		System.out.println(a.length());
		
		double[][] arr=MathUtil.arryParser1(a.substring(0, a.length()-2));
		//判断是否填入了数据
		if((a.length()-2)==0) {
			String err="请填入数据";
			mapper.writeValue(response.getWriter(), err);
		}else if(arr==null){//判断传来的数据是否符合规范
			String err="请填入符合规范的数据";
			mapper.writeValue(response.getWriter(), err);
		}else {
			int rank=MathUtil.Rank(arr, -1, arr.length);
			if(rank<arr[0].length) {
				String result="向量组线性相关";
				mapper.writeValue(response.getWriter(), result);
			}else if(rank==arr[0].length){
				String result="向量组线性无关";
				mapper.writeValue(response.getWriter(), result);
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
  			log.setL_behavior("线性相关的判断");
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
