package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.stereotype.Service;

import oracle.java.s20180102.model.ReviewDto;
@Service
public interface ReviewService {

	//List<ReviewDto> selReviewList(String ID, int GservNo); // 후기리스트 

	void inReview(ReviewDto revDto);                         // 후기 등록
	void upReview(ReviewDto revDto);                         // 후기 수정
	ReviewDto oneReview(ReviewDto revDto);                   // 하나의 후기
	List<ReviewDto> oneReviewList(ReviewDto revDto);         // 하나의 후기에 달린 답변들
	void inComment(ReviewDto revDto);                        // 코멘트 등록
	void delReview(ReviewDto revDto);                        // 후기 삭제
	void delComment(ReviewDto revDto);                       // 코멘트 삭제
	
}