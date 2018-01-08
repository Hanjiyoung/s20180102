package oracle.java.s20180102.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.model.ReviewDto;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public void inReview(ReviewDto revDto) {
		session.insert("inReview",revDto);
	}

	@Override
	public ReviewDto oneReview(ReviewDto revDto) {
		return session.selectOne("oneReview",revDto);
	}

	@Override
	public void upReview(ReviewDto revDto) {
		session.update("upReview", revDto);
	}

	

}
