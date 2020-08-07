package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ViewAndForward;
import dao.BoardDao;
import dto.BoardDto;

public class BoardViewCommand implements BoardCommand {

	@Override
	public ViewAndForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDto boardDto = BoardDao.getInstance().selectBoardByNo(no);
		
		
		// session 방식
//		request.setAttribute("boardDto", boardDto);
		HttpSession session = request.getSession();
		session.setAttribute("boardDto", boardDto);
		if (session.getAttribute("isViewOpen") == null) {
			session.setAttribute("isViewOpen", Boolean.TRUE);	// session"is--"열겠음
			BoardDao.getInstance().updateHit(no);	
		}
		
		ViewAndForward vaf = new ViewAndForward();
		vaf.setPath("board/viewBoard.jsp");
		vaf.setIsRedirect(true);
		
		return vaf;
		
	}

}
