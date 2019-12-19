package org.zerock.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;
import org.zerock.persistence.ReservationDAO;
import org.zerock.persistence.ReservationDAOImpl;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Inject
	private ReservationDAO rdao;
	
	@Override
	public void reservationSeat(ReservationVO rvo)
	{
		rdao.reservationSeat(rvo);
	}
	
	@Override
	public SeatVO SeatStatus(String sno)
	{
		System.out.println("service가 호출되었습니다 좌석 번호 : "+sno);
		return rdao.SeatStatus(sno); /* 컨트롤러에서 받은 좌석번호가 담긴 sno 변수를 rdao.SeatStatus 로 넘깁니다. */
	}
	
	@Override
	   public int duplicateCheck(ReservationVO rvo)
	   {
	      return rdao.duplicateCheck(rvo);
	   }
}
