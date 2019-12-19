package org.zerock.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;

public interface ReservationService {

	public void reservationSeat(ReservationVO rvo);
	public int duplicateCheck(ReservationVO rvo);
	public SeatVO SeatStatus(String sno);
}


