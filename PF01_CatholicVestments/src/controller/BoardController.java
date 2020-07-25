package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BoardCommand;
import command.BoardListCommand;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mapping = request.getRequestURI().substring(request.getContextPath().length());
		
		BoardCommand command = null;
		switch (mapping) {
		case "listBoard.do": 
			command = new BoardListCommand();
			break;
		}
		System.out.println("path전");
		String path = command.execute(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println("path후");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
