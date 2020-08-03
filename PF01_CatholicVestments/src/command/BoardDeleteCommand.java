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

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public ViewAndForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		final String DIRECTORY = "storage";
		String path = request.getServletContext().getRealPath("/" + DIRECTORY);
		
		MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		int no = Integer.parseInt(mr.getParameter("no"));
		String filename = mr.getFilesystemName("filename");

		File file = new File(path + "/" + filename);
		if ( file.exists()) {
			file.delete();
		}
		
		int result = BoardDao.getInstance().deleteBoard(no);
		
		ViewAndForward vaf = new ViewAndForward();
		vaf.setPath("board/boardDeleteResultPage.jsp?result=" + result);
		vaf.setIsRedirect(true);
		
		return vaf;
	}

}
