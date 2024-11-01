package com.acorn.cc;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods2 {
	String goodsCode;
	String goodsTitle;
	String goodsPrice;
	MultipartFile file;
}
