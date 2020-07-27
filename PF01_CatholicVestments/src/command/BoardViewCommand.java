package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDto;

public class BoardViewCommand implements BoardCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDto boardDto = BoardDao.getInstance().selectBoardByNo(no);
		
		request.setAttribute("boardDto", boardDto);
		
		return "/board/viewBoard.jsp";
		
	}

}
