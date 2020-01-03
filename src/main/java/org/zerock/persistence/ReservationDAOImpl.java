package org.zerock.persistence;

import java.io.PrintWriter;
//import java.net.http.HttpResponse;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;

//import com.sun.tools.javac.util.Names;

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
<<<<<<< HEAD
		return svo;  	
=======
		return svo;  
		
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
	}
	
	   
	@Override
	public void updateSeatStatus(SeatVO svo)
	{
		session.selectOne(namespace + ".updateseatstatus", svo);	
	}
	
	@Override
	public int UserDuplicateCheck(String uname)
	{
		int value = 0; 
		value = session.selectOne(namespace + ".UserDuplicateCheck", uname); // 예약을 한 사용자가 이미 예약목록 테이블에 존재하는지 안하는지 검사하는 코드입니다.
		return value;  // 존재하게 되면 1이  존재하지않으면 0이 return 됩니다.
	}
	
	
	
//	@Override  // 경진이가 짜면 추가
//	public void UpdateSeatStatus_Cancel(String[] Time) {
//		session.update(namespace + ".UpdateSeatStatus_Cancel",Time);
//	}
}


