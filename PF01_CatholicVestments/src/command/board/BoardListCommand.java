package command.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ViewAndForward;
import dao.BoardDao;
import dto.BoardDto;

public class BoardListCommand implements BoardCommand {

	@Override
	public ViewAndForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = BoardDao.getInstance();
		List<BoardDto> list = dao.selectBoardList();
		
		request.setAttribute("list", list);
		System.out.println("boardListCommand");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("isViewOpen") != null) {
			session.invalidate();
		}
		
		ViewAndForward vaf = new ViewAndForward();
		vaf.setPath("board/boardList.jsp");
		vaf.setIsRedirect(false);
		
		return vaf;
	}

}
