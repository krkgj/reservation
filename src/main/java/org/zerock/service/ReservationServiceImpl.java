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
		return rdao.SeatStatus(sno); 
	}
	
	@Override
	public int duplicateCheck(ReservationVO rvo)
	{
		return rdao.duplicateCheck(rvo);
	}
	
	@Override
	public void updateSeatStatus(SeatVO svo)
	{
		rdao.updateSeatStatus(svo);
	}
	
}