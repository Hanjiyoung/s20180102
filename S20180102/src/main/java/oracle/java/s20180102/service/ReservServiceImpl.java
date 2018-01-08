package oracle.java.s20180102.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.ReservDao;
import oracle.java.s20180102.dao.WishDao;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.model.WishDto;

@Service
public class ReservServiceImpl implements ReservService{
	@Autowired
	private ReservDao resDao;

	@Override
	public int totalResv(String ID) {
		
		return resDao.totalResv(ID);
	}

	@Override
	public List<ReservDto> selReservList(PagingDto pdto) {
		
		return resDao.selReservList(pdto);
	}

	@Override
	public ReservDto oneResv(String payCode) {
		return resDao.oneResv(payCode);
	}

	@Override
	public int total_Complete(String ID) {
		return resDao.total_Complete(ID);
	}

	@Override
	public List<ReservDto> completeList(PagingDto pdto) {
		return resDao.completeList(pdto);
	}

	@Override
	public void resvCancel(String payCode) {
		resDao.resvCancel(payCode);
	}


	
}