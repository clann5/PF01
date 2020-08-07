package command.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface JsonCommand {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
