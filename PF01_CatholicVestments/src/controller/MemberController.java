package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.etc.JsonCommand;
import command.etc.CaptchaImageCommand;
import command.etc.CheckCaptchaCommand;
import command.member.AjaxSignupCommand;
import command.member.MemberCommand;
import command.member.MemberLoginCommand;
import common.ViewAndForward;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String mapping = requestURI.substring(contextPath.length());
		
		JsonCommand jsonCommand = null;
		String path = null;
		
		JsonCommand ajaxCommand = null; 
		String result = null;
		PrintWriter out = response.getWriter();

		MemberCommand mCommand = null;
		ViewAndForward vaf = null;
		
		try {
			
			switch (mapping) {
			case "/getCaptchaImage.member" :
				jsonCommand = new CaptchaImageCommand();
				path = jsonCommand.execute(request, response);
				break;
//			case "/login.member":
//				command = new CheckCaptchaCommand();
//				path = command.execute(request, response);
//				break;
			case "/login.member":
				mCommand = new MemberLoginCommand();
				vaf = mCommand.execute(request, response);
				break;
			case "/signup.member":
				ajaxCommand = new AjaxSignupCommand();
				result = ajaxCommand.execute(request, response);
				out.println(result);
				break;
				
				
			case "/signupPage.member":
				vaf = new ViewAndForward();
				vaf.setPath("member/signup.jsp");
				vaf.setIsRedirect(true);
				break;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("path log : " + path);
		System.out.println("result log : " + result);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
