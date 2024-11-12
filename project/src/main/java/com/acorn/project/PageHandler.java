package com.acorn.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageHandler {
	int currentPage; // 현재페이지
	int totRecords; // 총 레코드 수
	int pageSize; // 페이지 사이즈( 한 페이지에 보이는 레코드 수 )
	int totalPage; // 총페이지 수 : 전체 페이지 수
	
	int grpSize = 5; // 한 그룹당 5개
	int currentGrp; // 현재 그룹
	int grpStartPage; // 현재그룹의 시작번호
	int grpEndPage; // 현재 그룹의 마지막 번호
	
	public PageHandler (int page, int totRecord, int pageSize) {
		this.currentPage = page;
		this.totRecords = totRecords;
		this.pageSize = pageSize;
		
		//페이징 관련 값 구하기 
		calcPage();
	}
	
	private void calcPage() {
		int remain = totRecords % pageSize;
		
		// 총 페이지 수 구하기 
		if (remain == 0) totalPage = totRecords / pageSize;
		else totalPage = totRecords / pageSize + 1;
		
		int remain2 = currentPage % grpSize;
		
		if(remain2 == 0) currentGrp = currentPage / grpSize;
		else currentGrp = currentPage / grpSize + 1;
		
		grpStartPage = (currentGrp -1) * grpSize + 1;
		grpEndPage = currentGrp * grpSize;
		
		if (grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
	}
	
}
