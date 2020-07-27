package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.BoardDao;
import dto.BoardDto;

public class BoardListCommand implements BoardCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("에러나나?");
		BoardDao dao = BoardDao.getInstance();
		List<BoardDto> list = dao.selectBoardList();
		
		request.setAttribute("list", list);
		System.out.println("boardListCommand");
		
		return "board/boardList.jsp";
	}

}
