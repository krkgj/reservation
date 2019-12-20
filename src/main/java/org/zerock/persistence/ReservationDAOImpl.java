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

import com.sun.tools.javac.util.Names;

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
		SeatVO svo = session.selectOne(namespace+ ".seatstatus" , sno);
		return svo;  
		
	}
	
	@Override
	public int duplicateCheck(ReservationVO rvo)
	{
		int value = 0;
		value = session.selectOne(namespace + ".duplicateCheck", rvo);
	    
		return value;
	}
	   
	@Override
	public void updateSeatStatus(SeatVO svo)
	{
		session.selectOne(namespace + ".updateseatstatus", svo);	
	}
}


