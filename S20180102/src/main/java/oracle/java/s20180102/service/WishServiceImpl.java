package oracle.java.s20180102.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.WishDao;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.WishDto;

@Service
public class WishServiceImpl implements WishService{
	@Autowired
	private WishDao wishDao;

	@Override
	public List<GServDto> selWishList(String Id) {
		return wishDao.selWishList(Id);
	}
	
}