package oracle.java.s20180102.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.ReviewDao;
import oracle.java.s20180102.dao.WishDao;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.PayDto;
import oracle.java.s20180102.model.ReviewDto;
import oracle.java.s20180102.model.TourCardDto;
import oracle.java.s20180102.model.WishDto;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDao revDao;

	@Override
	public void inReview(ReviewDto revDto) {
		revDao.inReview(revDto);
	}

	@Override
	public ReviewDto oneReview(ReviewDto revDto) {
		return revDao.oneReview(revDto);
	}

	@Override
	public void upReview(ReviewDto revDto) {
		revDao.upReview(revDto);
	}



	
}