package com.acorn.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KakaoApiService {

    private final RestaurantService restaurantService;

    @Autowired
    public KakaoApiService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void fetchAndSaveRestaurants() throws Exception {
        int page = 1;
        boolean isEnd = false;

        while (!isEnd) {
            // url 생성 
            String urlStr = buildUrl(126.920592, 37.554053, 2000, page);
            String response = fetchDataFromApi(urlStr);
            
            // 파싱
            List<Restaurant> restaurants = parseRestaurants(response);
            saveRestaurants(restaurants);
            
            // 페이지 요청 확인
            JSONObject body = new JSONObject(response);
            JSONObject meta = body.getJSONObject("meta");
            isEnd = meta.getBoolean("is_end");
            System.out.println(isEnd);
            System.out.println(page);
            page++;
        }
    }

    private String buildUrl(double x, double y, int radius, int page) throws Exception {
        return "https://dapi.kakao.com/v2/local/search/category.json?x=" + x + "&y=" + y + "&radius=" + radius
                + "&category_group_code=FD6" + "&page=" + page;
    }

    private String fetchDataFromApi(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK 5bea60374e0f1e3a2fe81e81ace6fa35");
        conn.setRequestProperty("Content-type", "application/json");

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ? conn.getInputStream()
                        : conn.getErrorStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            conn.disconnect();
        }
    }

    // Restaurant 객체 목록으로 변환
    private List<Restaurant> parseRestaurants(String response) {
        List<Restaurant> restaurants = new ArrayList<>();
        JSONObject body = new JSONObject(response);
        JSONArray arr = body.getJSONArray("documents");

        for (int i = 0; i < arr.length(); i++) {
            JSONObject jobj = arr.getJSONObject(i);

            Restaurant restaurant = new Restaurant();
            restaurant.setPlaceName(jobj.getString("place_name"));
            restaurant.setAddressName(jobj.getString("address_name"));
            restaurant.setDistance(jobj.getString("distance"));
            restaurant.setPlaceUrl(jobj.getString("place_url"));
            restaurant.setLongitude(jobj.getString("x"));
            restaurant.setLatitude(jobj.getString("y"));

            String[] categoryParts = jobj.getString("category_name").split(">");
            String categoryName = categoryParts.length > 1 ? categoryParts[1].trim() : categoryParts[0].trim();
            restaurant.setCategoryName(categoryName);

            restaurants.add(restaurant);
        }

        return restaurants;
    }

    private void saveRestaurants(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            restaurantService.addRestaurantInfo(restaurant);
        }
    }
  
 
}