package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDto;

public class InsertBoardPageCommand implements BoardCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDto boardDto = new BoardDto();
		HttpSession session = request.getSession();
		
		session.setAttribute("ss_user_id", request.getParameter("user_id"));
		
		return "/board/insertBoardPage.jsp";
	}

}
