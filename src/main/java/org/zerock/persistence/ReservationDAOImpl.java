package org.zerock.persistence;

import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace ="org.zerock.mapper.ReservationMapper";
	
	@Override
	public void reservationSeat(ReservationVO rvo)
	{
		try {
			session.selectOne(namespace+ ".reservation" , rvo);
		} catch (Exception e) {
			// TODO: handle exception			'
			
		}
	}
	
	@Override
	public SeatVO SeatStatus(String sno)
	{
		System.out.println("dao가 호출되었습니다 좌석 번호 : "+ sno);
		SeatVO svo = session.selectOne(namespace+ ".seatstatus" , sno);
		System.out.println("DB에서 가져온 객체의 좌석번호 : "+svo.getSeat());
		return svo;  
		
		/* 서비스에서 받은 좌석번호담긴 sno 변수를 쿼리문을 실행하기위해 mapper 에 넘겨줍니다. */
	}
	
	   @Override
	   public int duplicateCheck(ReservationVO rvo)
	   {
	      int value = 0;
	      /* try { */
	         value = session.selectOne(namespace + ".duplicateCheck", rvo);
	      /*
	       * } catch (Exception e) { return 0; }
	       */return value;
	      
	   }
}


