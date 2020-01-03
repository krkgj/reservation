package org.zerock.persistence;

import org.zerock.domain.VisitcountVO;

public interface VisitCountDAO {
	public void insertVisitor(VisitcountVO vo);
	  public VisitCountDAOImpl getInstance();
}
