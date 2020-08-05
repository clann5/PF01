package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CaptchaCommand;
import command.CaptchaImageCommand;
import command.CheckCaptchaCommand;

@WebServlet("*.api")
public class CaptchaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CaptchaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String mapping = requestURI.substring(contextPath.length());
		
		CaptchaCommand command = null;
		String path = null;
		
		try {
			
			switch (mapping) {
			case "/getCaptchaImage.api" :
				command = new CaptchaImageCommand();
				path = command.execute(request, response);
				break;
			case "/login.api":
				command = new CheckCaptchaCommand();
				path = command.execute(request, response);
				break;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("request log : " + request);
		System.out.println("path log : " + path);
		System.out.println("command log : " + command);
		System.out.println("request.Dispatcher log : " + request.getRequestDispatcher(path));
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
