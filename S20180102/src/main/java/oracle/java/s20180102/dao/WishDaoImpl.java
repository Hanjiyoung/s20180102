package oracle.java.s20180102.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.WishDto;

@Repository
public class WishDaoImpl implements WishDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<GServDto> selWishList(String Id) {
		return session.selectList("selWishList", Id);
	}
	
}