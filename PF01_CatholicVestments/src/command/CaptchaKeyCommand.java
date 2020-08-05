package command;

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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CaptchaKeyCommand implements CaptchaCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. 네이버에게서 캡차 키 발급 받기
		String clientId = "o_JfUkabMp6WRi2tVAVi";
		String clientSecret = "CpuP_zc3Z5";
		
		// Ex01_getCaptchaKey.java 를 실행하고, String key 를 받아온다
		
		String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
		
		Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL, requestHeaders);	// 네이버가 발급해 준 key 값이 저장된 reponseBody

        // responseBody
        // {"key":"발급받은 키값"}
        
        // 발급받은 키값을 String key 에 저장한다.
        String key = "";
        JSONParser parser = new JSONParser();
        System.out.println("responseBody Log : " + responseBody);
        System.out.println("parser Log : " + parser);
        Object obj = parser.parse(responseBody);
        JSONObject jsonObj = (JSONObject)obj;
        key = (String)jsonObj.get("key");
        
        System.out.println("key log : "+key);
		return key;
	}

	// Method : get
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
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

    private static String readBody(InputStream body){
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