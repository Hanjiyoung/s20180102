package oracle.java.s20180102.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.MemberDao;
import oracle.java.s20180102.dao.PayDao;
import oracle.java.s20180102.dao.ReservDao;
import oracle.java.s20180102.dao.WishDao;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.MemberDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.PayDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.model.WishDto;

@Service
public class PayServiceImpl implements PayService{
	@Autowired
	private PayDao pDao;

	@Override
	public int total(String iD) {
		return pDao.total(iD);
	}

	@Override
	public List<PayDto> selPayList(PagingDto pdto) {
		return pDao.selPayList(pdto);
	}



	
}