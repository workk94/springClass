package com.acorn.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
	
	// page가 isEnd가 true일때까지 반복문을 수행하려함 
	
	
	public static void main(String[] args) throws Exception {

		// query : 키워드 필수 값
		// x : 경도값 126.920592
		// y : 위도값 37.554053
		// radius : 중심좌표로부터 반경거리
		String urlStr = "https://dapi.kakao.com/v2/local/search/keyword.json?x=126.920592&y=37.554053&radius=200&query=" 
			    + URLEncoder.encode("맛집", "UTF-8") + "&page=1";

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

		JSONObject body = new JSONObject(sb.toString());
		JSONArray arr =  body.getJSONArray("documents");
		
		for(int i = 0 ; i < arr.length(); i++) {
			JSONObject  jobj =  arr.getJSONObject(i);
			System.out.println(jobj.getString("place_name"));
			System.out.println(jobj.getString("address_name"));
			System.out.println(jobj.getString("distance"));
			System.out.println(jobj.getString("place_url"));
			
			System.out.println(jobj.getString("x"));
			System.out.println(jobj.getString("y"));
			String[] result = jobj.getString("category_name").split(">");
			String result2 = result[1].trim();
			
			System.out.println(result2);
		}
		
		
		// meta에 있는 is_end를 출력함 
		JSONObject obj = body.getJSONObject("meta");
		boolean isEnd = obj.getBoolean("is_end");
		System.out.println(isEnd);		
	}
}
