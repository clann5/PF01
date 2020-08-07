package command.etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaImageCommand implements JsonCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String clientId = "o_JfUkabMp6WRi2tVAVi";
		String clientSecret = "CpuP_zc3Z5";

        JsonCommand command = new CaptchaKeyCommand();
        String key = command.execute(request, response); // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
//        String key = null;
        System.out.println("key log : " + key);
        String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(request, apiURL,requestHeaders);
        
        // 기본 API 소스에서는 responseBod 는 "이미지 캡차가 생성되었습니다."이다
        // 수정본에서는 getImage() 메소드의 return filename + ".jpg";
        // 그러면 responseBody 는 생성된 캡차 이미지 파일명.jpg이 저장된다.

    	// 캡차이미지가 저장된 경로를 JSP 에서 확인할 수 있도록 request 에 담아둔다.
        request.setAttribute("filename", responseBody);
        // 비교를 위해 발급받은 key 값을 login.jsp -> CheckCaptchaCommand.java 로 전달해야 한다.
        request.setAttribute("key", key);
        System.out.println("filename log : "+responseBody);
		
		return "member/loginPage.jsp";
	}
	
	 private static String get(HttpServletRequest request, String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return getImage(request, con.getInputStream());
	            } else { // 에러 발생
	                return error(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }

	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }

	    private static String getImage(HttpServletRequest request, InputStream is){
	    	
	    	// 캡차이미지를 저장할 경로
	    	final String DIRECTORY = "storage";
	    	String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
	    	File path = new File(realPath);
	    	if (!path.exists()) {
				path.mkdirs();
			}
	    	
	    	// 캡차이미지가 저장된 경로를 JSP 에서 확인할 수 있도록 request 에 담아둔다.
	    	request.setAttribute("DIRECTORY", DIRECTORY);
	    	
	    	
	        int read;
	        byte[] bytes = new byte[1024];
	        // 랜덤한 이름으로  파일 생성
	        String filename = Long.valueOf(new Date().getTime()).toString();
	        File f = new File(realPath, filename + ".jpg");
	        try(OutputStream outputStream = new FileOutputStream(f)){
	            f.createNewFile();
	            while ((read = is.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }
//	            return "이미지 캡차가 생성되었습니다.";
	            return filename + ".jpg";	
	        } catch (IOException e) {
	            throw new RuntimeException("이미지 캡차 파일 생성에 실패 했습니다.",e);
	        }
	    }

	    private static String error(InputStream body) {
	        InputStreamReader streamReader = new InputStreamReader(body);

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }

}