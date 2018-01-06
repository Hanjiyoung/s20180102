package oracle.java.s20180102.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import oracle.java.s20180102.dao.MemberDao;
import oracle.java.s20180102.dao.ReservDao;
import oracle.java.s20180102.dao.WishDao;
import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.MemberDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.model.WishDto;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao mbDao;

	@Override
	public MemberDto selMember(String id) {
		return mbDao.selMember(id);
	}


	
}