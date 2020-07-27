package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dto.BoardDto;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
//		String user_id = request.getParameter("user_id");
		String user_id = (String)session.getAttribute("ss_user_id");
		String content = request.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setTitle(title);
		boardDto.setUser_id(user_id);
		boardDto.setContent(content);
		
		int result = BoardDao.getInstance().insertBoard(boardDto);
		
		String path = "";
		if(result > 0) {
			path = "/listBoard.do";
		} else {
			path = "/insertBoardPage.jsp";
		}
		return path;
	}

}
