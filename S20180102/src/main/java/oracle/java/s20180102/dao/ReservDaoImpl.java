package oracle.java.s20180102.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;

@Repository
public class ReservDaoImpl implements ReservDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<ReservDto> selReservList(PagingDto pdto) {
		return session.selectList("selReservList",pdto);
	}

	@Override
	public int totalResv(String ID) {
		return session.selectOne("totalResv",ID);
	}

	@Override
	public ReservDto oneResv(String payCode) {
		return session.selectOne("oneResv",payCode);
	}

	@Override
	public int total_Complete(String ID) {
		return session.selectOne("total_Complete",ID);
	}

	@Override
	public List<ReservDto> completeList(PagingDto pdto) {
		return session.selectList("completeList",pdto);
	}

	@Override
	public void resvCancel(String payCode) {
		session.update("resvCancel", payCode);		
	}

}
