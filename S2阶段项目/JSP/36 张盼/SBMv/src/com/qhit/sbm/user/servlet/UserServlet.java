/**
 * 
 */
package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.impl.UserServiceImpl;
import com.qhit.sbm.utils.CommonUtil;
import com.qhit.sbm.utils.IDUtil;

/**
 * @author admin
 * 2017年11月13日
 */
public class UserServlet extends HttpServlet {
	private UserService usService = new UserServiceImpl();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "login":
			doLogin(request, response);
			break;
		case "exit":
			doExit(request, response);
			break;
		case "uploadPic":
			uploadPic(request, response);
			break;
		case "addUser":
			addUser(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String userName = (String)request.getAttribute("userName");
		String userPassword = (String)request.getAttribute("userPassword");
		String userSex = (String)request.getAttribute("userSex");
		String userAge = (String)request.getAttribute("userAge");//int
		String telephone = (String)request.getAttribute("telephone");
		String address = (String)request.getAttribute("address");
		String type = (String)request.getAttribute("type");//int
		//头像服务器存储路径是request.setAttribute("picPath", picPath);
		String pic = (String) request.getAttribute("pic");
		
		User user = new User(
				userName, 
				userPassword, 
				userSex, 
				Integer.parseInt(userAge), 
				telephone, 
				address,
				pic, 
				Integer.parseInt(type)
				);
		
		int row = usService.addUser(user);
		
		PrintWriter out = response.getWriter();
		if(row > 0){
			//添加成功：应该重定向到user控制层重新查询所有的用户列表
//			out.print("<script>alert('添加成功');</script>");
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			//添加失败
			out.print("<script>alert('添加失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 上传头像
	 * @throws ServletException 
	 * @throws IOException 
	 */
	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		
		//实例化对象
		SmartUpload smartUpload = new SmartUpload();
		//初始化上传文件对象
		smartUpload.initialize(getServletConfig(), request, response);
		//设置只允许上传图片
		smartUpload.setAllowedFilesList("png,jpg,JPEG,gif");
		//设置文件的大小最大5M
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			//上传
			smartUpload.upload();
			
			
			
			//保存
			//图片保存的文件夹路径
			String realPath =  request.getRealPath("/")+"/";//项目路径
			String filePath = CommonUtil.FILE_USER_PIC_PHOTO_PATH;
			java.io.File file = new java.io.File(realPath+filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//图片保存的名称
			String picName = IDUtil.getUUID();
			//图片的后缀名
			File picFile = smartUpload.getFiles().getFile(0);
			String picFileExt = picFile.getFileExt();
			//最终获取到的文件相对路径
			String picPath = filePath+picName+"."+picFileExt;
			//保存文件
			picFile.saveAs(realPath+picPath);
			//头像上传成功，之后根据表单提交的数据和获取头像图片的存储路径插入数据表中：因为需要之前表单的所有的数据所以需要用到请求转发
			//添加用户头像的路径到request对象中，转发出去
			
			Request sRequest = smartUpload.getRequest();
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			rDispatcher.forward(request, response);
		} catch (SmartUploadException e) {
			//异常处理
			out.print("<script>alert('上传头像失败，请检查图片格式和大小');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 退出功能
	 * @throws IOException 
	 */
	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
//		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}

	/**
	 * @param request
	 * @param response
	 * 登录功能
	 * @throws IOException 
	 */
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		User user = usService.doLogin(userName, userPassword);
		
		if(user != null){
			/**
			 * 登陆成功
			 * */
			//保存用户信息到会话中
			request.getSession().setAttribute("user", user);
			//获取在线用户集合
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for (User user2 : users) {
				if(user2.getUserId() == user.getUserId()){
					//说明当前用户已经在线,直接跳转就可以
					isOnline = true;
					break;
				}
			}
			if(isOnline){
				response.sendRedirect("account?cmd=getPageBean");
//				response.sendRedirect("jsp/admin_index.jsp");
			}else{
				//添加当前用户到在线用户集合
				users.add(user);
				//更新在线用户集合
				request.getServletContext().setAttribute("online", users);
				//跳转页面
				response.sendRedirect("jsp/admin_index.jsp");
			}
		}else{
			//登录失败
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
