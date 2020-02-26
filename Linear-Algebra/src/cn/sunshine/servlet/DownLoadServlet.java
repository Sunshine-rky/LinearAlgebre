package cn.sunshine.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.Log;
import cn.sunshine.bean.User;
import cn.sunshine.service.AlgorithmService;
import cn.sunshine.service.LogService;
import cn.sunshine.serviceImpl.AlgorithmServiceImpl;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.util.MyUtil;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/downloadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File downLoadFileDir =new File(getServletContext().getRealPath("file"));
		String aFileName=null;
		FileInputStream in=null;
		ServletOutputStream out=null;
		try {
			aFileName=request.getParameter("resPath");
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename="+MyUtil.toUTF8String(aFileName));
			in=new FileInputStream(downLoadFileDir+File.separator+aFileName);
			out=response.getOutputStream();
			out.flush();
			int aRead=0;
			byte b[]=new byte[1024];
			while((aRead=in.read(b))!=-1&in!=null) {
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		
			
			//操作数据库
			String name=request.getParameter("resPath");
			String money=request.getParameter("resPath1");
			String u_email=(String)request.getSession().getAttribute("email");
			AlgorithmService as =new 	AlgorithmServiceImpl();
			//下载者减金币
			Algorithm a=new Algorithm();
			a.setU_email(u_email);
			a.setM_money(money);
			a.setM_name(name);
			as.subMoney(a);
			as.addMoney(a);
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
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
			log.setL_behavior("下载文件");
			log.setL_modular("上传下载模块");
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
