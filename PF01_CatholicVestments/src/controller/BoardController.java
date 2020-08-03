package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BoardCommand;
import command.BoardDeleteCommand;
import command.BoardListCommand;
import command.BoardUpdateCommand;
import command.BoardViewCommand;
import command.BoardInsertCommand;
import common.Download;
import common.ViewAndForward;

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
		ViewAndForward vaf = null;
		try {
			switch (mapping) {
			case "/boardList.do": 
				command = new BoardListCommand();
				vaf = command.execute(request, response);
				break;
			case "/boardView.do":
				command = new BoardViewCommand();
				vaf = command.execute(request, response);
				break;
			case "/boardInsert.do":
				command = new BoardInsertCommand();
				vaf = command.execute(request, response);
				break;
			case "/boardUpdate.do":
				command = new BoardUpdateCommand();
				vaf = command.execute(request, response);
				break;
			case "/boardDelete.do":
				command = new BoardDeleteCommand();
				vaf = command.execute(request, response);
				break;
				
				
			// 공통기능
			case "/download.do":
				Download.download(request, response);
				break;
			// 단순이동
			case "/boardInsertPage.do":
				vaf = new ViewAndForward();
				vaf.setPath("board/boardInsertPage.jsp");
				vaf.setIsRedirect(true);
				break;
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (vaf != null) {
			if (vaf.getIsRedirect()) {
				response.sendRedirect(vaf.getPath());
			} else {
				request.getRequestDispatcher(vaf.getPath()).forward(request, response);
//				System.out.println("request : " + request );
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
