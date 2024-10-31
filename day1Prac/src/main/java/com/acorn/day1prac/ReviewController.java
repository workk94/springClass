package com.acorn.day1prac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {
	
	List<Review> list = new ArrayList<>(); 
	
    @GetMapping("/reviews")
    public String getReviews() {
        return "review";
    }

    @GetMapping("/reviews/new")
    public String showReviewForm() {
        return "addReview";
    }

    @PostMapping("/addReviews")
    public String addReview(Review review) {
        list.add(review);  

        System.out.println(review.getTitle());
        System.out.println(review.getContent());
        list.forEach(t -> System.out.println(t));
        System.out.println("리뷰 개수: " + list.size());

        return "redirect:/reviews";
    }
	
}
