package oracle.java.s20180102.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

import oracle.java.s20180102.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSession session;

	@Override
	public MemberDto selMember(String id) {
		return session.selectOne("selMember", id);
	}
	
}