package command.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ViewAndForward;
import dao.BoardDao;
import dto.BoardDto;

public class BoardInsertCommand implements BoardCommand {

	@Override
	public ViewAndForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		final String DIRECTORY = "storage";
		String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
		File filePath = new File(realPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*10,"utf-8",new DefaultFileRenamePolicy());

		BoardDto boardDto = new BoardDto();
		String bTitle = mr.getParameter("bTitle");	
		String mId = mr.getParameter("mId");
		String bContent = mr.getParameter("bContent");
		String bFilename = mr.getFilesystemName("bFilename");
		String bPw = mr.getParameter("bPw");
		
		boardDto.setbTitle(bTitle);
		boardDto.setmId(mId);
		boardDto.setbContent(bContent);
		boardDto.setbPw(bPw);
		if (mr.getFile("bFilename") == null) {
			boardDto.setbFilename("");
		} else {
			boardDto.setbFilename(bFilename);
		}
		
		
		int result = BoardDao.getInstance().insertBoard(boardDto);
		
		ViewAndForward vaf = new ViewAndForward();
		vaf.setPath("board/boardInsertResultPage.jsp?result="+result);
		System.out.println("result :" + result);
		vaf.setIsRedirect(true);
		
		return vaf;
	}

}
