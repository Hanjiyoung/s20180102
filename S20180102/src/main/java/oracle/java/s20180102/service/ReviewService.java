package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.stereotype.Service;

import oracle.java.s20180102.model.ReviewDto;
@Service
public interface ReviewService {

	void inReview(ReviewDto revDto);                         // 후기 등록
	//List<ReviewDto> selReviewList(String ID, int GservNo); // 후기리스트 
	//int delReview(ReviewDto reviewDto);                    // 후기 삭제	

	ReviewDto oneReview(ReviewDto revDto);                   // 하나의 후기

	void upReview(ReviewDto revDto);                         // 후기 수정
}