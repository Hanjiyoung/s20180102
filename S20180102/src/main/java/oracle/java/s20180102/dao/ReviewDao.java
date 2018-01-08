package oracle.java.s20180102.dao;

import java.util.List;

import oracle.java.s20180102.model.ReviewDto;

public interface ReviewDao {
	//List<ReviewDto> selReviewList(String ID, int GservNo); // 후기리스트 
	void inReview(ReviewDto revDto);                     // 후기 등록
	//int delReview(ReviewDto revDto);                    // 후기 삭제	

	ReviewDto oneReview(ReviewDto revDto);                // 하나의 후기 선택
 
	void upReview(ReviewDto revDto);                        // 후기 수정
}