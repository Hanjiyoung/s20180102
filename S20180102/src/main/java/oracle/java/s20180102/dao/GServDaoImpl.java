package oracle.java.s20180102.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

@Repository
public class GServDaoImpl implements GServDao{
	@Autowired
	private SqlSession session;
	
}