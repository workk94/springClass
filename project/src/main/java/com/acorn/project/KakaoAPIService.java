package com.acorn.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KakaoAPIService {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getMapData(Model model) throws Exception {
		
		return fetchMapData("10");
	}
	
	
	public List<Member> parseMapData(String jsonStr) throws Exception {
		List<Member> list = new ArrayList<>();
		
		fetchMapData("10");
		return null;
	}
	
	public String fetchMapData(String page) throws Exception {
		// query : 키워드 필수 값 
		// x : 경도값 126.920592
		// y : 위도값 37.554053
		// radius : 중심좌표로부터 반경거리 
		 String urlStr = String.format(
			        "https://dapi.kakao.com/v2/local/search/keyword.json?x=%s&y=%s&radius=200&query=%s&page=" + page,
			        "126.920592", "37.554053", URLEncoder.encode("맛집", "UTF-8")
			    );
		 
		URL url = new URL(urlStr);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");		
	    conn.setRequestProperty("Authorization", "KakaoAK 5bea60374e0f1e3a2fe81e81ace6fa35");
		conn.setRequestProperty("Content-type", "application/json");

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ? conn.getInputStream()
						: conn.getErrorStream()));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		return sb.toString();
	}
}
