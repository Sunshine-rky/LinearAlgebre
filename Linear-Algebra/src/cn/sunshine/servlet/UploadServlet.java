package cn.sunshine.servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.sunshine.bean.Algorithm;
import cn.sunshine.bean.Log;
import cn.sunshine.service.AlgorithmService;
import cn.sunshine.service.LogService;
import cn.sunshine.service.UserService;
import cn.sunshine.serviceImpl.AlgorithmServiceImpl;
import cn.sunshine.serviceImpl.LogServiceImpl;
import cn.sunshine.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//Part part=request.getPart("file");
//String f1=part.getHeader("Content-Disposition");
//String f2=f1.substring(f1.lastIndexOf("."),f1.length()-1);
//SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm ssSSS");
//String f3=format.format(new Date());
//String f4=f3+f2;
//InputStream is=part.getInputStream();
//String f5=request.getServletContext().getRealPath("/file");
//String file=f5+"\\"+f4;
//System.out.println(file);
//FileOutputStream fosFileOutputStream=new FileOutputStream(f5+"\\"+f4);
//String f6="D:\\success";
//FileOutputStream fosFileOutputStream1=new FileOutputStream(f6+"\\"+f4);
//String file1=f6+"\\"+f4;
//System.out.println(file1);
//byte[] bty=new byte[1024];
//int length=0;
//while((length=is.read(bty))!=-1) {                                           
//	fosFileOutputStream.write(bty,0,length);	
//fosFileOutputStream1.write(bty,0,length);
//}
//is.close();
////fosFileOutputStream1.close();
//fosFileOutputStream.close();
//String u_email=(String)request.getSession().getAttribute("email");
//String a_location=f5+"/"+f4;
//Algorithm a=new Algorithm();
//a.setU_email(u_email);
//a.setM_location(a_location);
//UserService us=new UserServiceImpl();
//us.upload(a);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//Servlet3.0中新引入的方法，用来处理multipart/form-data类型编码的表单
		Part part = request.getPart("file");
		//获取HTTP头信息headerInfo=（form-data; name="file" filename="文件名"）
        String headerInfo = part.getHeader("content-disposition");
//		System.out.println(headerInfo);
		//从HTTP头信息中获取文件名fileName=（文件名）
//		String fileName=getFilename(part);
		String fileName = headerInfo.substring(headerInfo.lastIndexOf("\\")+1,headerInfo.length()-1);
		System.out.println(fileName);
		//获得存储上传文件的文件夹路径
		String fileSavingFolder = this.getServletContext().getRealPath("file");
		System.out.println(fileSavingFolder);
		//获得存储上传文件的完整路径（文件夹路径+文件名）
		//文件夹位置固定，文件夹采用与上传文件的原始名字相同
		String fileSavingPath = fileSavingFolder + File.separator + fileName;
		System.out.println(fileSavingPath);
		//如果存储上传文件的文件夹不存在，则创建文件夹
		File f = new File(fileSavingFolder + File.separator);
		
		if(!f.exists()){
			f.mkdirs();
		}
		//将上传的文件内容写入服务器文件中
		part.write(fileSavingPath);
		//输出上传成功信息
		out.println("文件上传成功~！");
		 Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String l_time= simpleDateFormat.format(now);
		String u_name=(String)request.getSession().getAttribute("name");
		String u_email=(String)request.getSession().getAttribute("email");
		String m_money=request.getParameter("m_money");
		String a_location=fileSavingPath;
		Algorithm a=new Algorithm();
		a.setU_email(u_email);
		a.setM_location(a_location);
		a.setM_money(m_money);
		a.setM_time(l_time);
		a.setU_name(u_name);
		a.setM_name(fileName);
		AlgorithmService as=new AlgorithmServiceImpl();
		as.addAlgorithm(a);
		
		
		//存入日志中
		Log log=new Log();
//		 Date now = new Date();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String l_time= simpleDateFormat.format(now);
			
		//	String u_email=(String)request.getSession().getAttribute("email");
//			String u_name=(String)request.getSession().getAttribute("name");
			log.setL_time(l_time);
			log.setU_email(u_email);
			log.setU_name(u_name);
			log.setL_behavior("上传算法");
			log.setL_modular("上传下载模块");
			LogService ls=new LogServiceImpl();
			ls.add(log);
		
	}	
	
	}

