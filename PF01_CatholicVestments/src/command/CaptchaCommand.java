package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaCommand {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
