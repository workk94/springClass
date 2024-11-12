package com.acorn.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	private String placeName;
    private String addressName;
    private String distance;
    private String placeUrl;
    private String longitude; // longitude 경도 x 
    private String latitude; // latitude 위도 y
    private String categoryName;
}
