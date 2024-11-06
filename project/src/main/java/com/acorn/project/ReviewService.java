package com.acorn.project;

import java.util.List;

public interface ReviewService {

	// 가게별로 리뷰 가져오기
	public List<Review> getReview();
	
	// 유저 아이디로 리뷰가져오기
	public List<Review> getReviewById(String userId);
	
	// 리뷰등록하기
	public int addReview(Review newReview);
	
	// 리뷰수정하기 
	public int updateReview(Review review);
	
	// 리뷰 삭제하기 
	public int deleteReview();
}
