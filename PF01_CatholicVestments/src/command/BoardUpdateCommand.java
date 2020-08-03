package command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ViewAndForward;
import dao.BoardDao;
import dto.BoardDto;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public ViewAndForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		final String DIRECTORY = "storage";
		String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
		
		File path = new File(realPath);
		if (!path.exists()) {
			path.mkdirs();
		}
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		
		int no = Integer.parseInt(mr.getParameter("no"));
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(no);
		boardDto.setTitle(title);
		boardDto.setContent(content);
		
		HttpSession session = request.getSession();
		String oldFile = ((BoardDto)session.getAttribute("boardDto")).getFilename();
		
		File newFile = mr.getFile("filename");

		// 기존파일 삭제
		if (oldFile != null && newFile != null) {
			File file = new File(realPath, oldFile);
			if ( file.exists()) {
				file.delete();
			}
		}
		
		// 새 파일 저장
		if (newFile != null) {
			boardDto.setFilename(mr.getFilesystemName("filename"));
		}
		
		int result = BoardDao.getInstance().updateBoard(boardDto); 
		
		ViewAndForward vaf = new ViewAndForward();
		vaf.setPath("board/boardUpdateResultPage.jsp?result=" + result);
		vaf.setIsRedirect(true);
		return vaf;
	}

}
