package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.VisitcountVO;

@Repository
public class VisitCountDAOImpl implements VisitCountDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace ="org.zerock.mapper.visitCounterMapper";
		
	@Override
	  public void insertVisitor(VisitcountVO vo)
	  {
		System.out.println(vo.getVisit_ip());
		System.out.println(vo.getVisit_agent());
		
		 session.selectOne(namespace+ ".visitCounter" , vo);
		 System.out.println("visitcountDAO È°¼ºÈ­!");
	  }
	  
	@Override
	  public VisitCountDAOImpl getInstance()
	  {
		  return new VisitCountDAOImpl();
	  }
	 
}
