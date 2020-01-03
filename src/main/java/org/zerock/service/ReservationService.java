package org.zerock.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;

public interface ReservationService {

	public void reservationSeat(ReservationVO rvo);
	public SeatVO SeatStatus(String sno);
	public void updateSeatStatus(SeatVO svo);
	public int UserDuplicateCheck(String uname);
	public SeatVO compareSeatStatus(String[] reservationTime, SeatVO svo);
	public ReservationVO useConvert(String[] reservationTime, HttpSession session, ReservationVO rvo, String uname, String unumber, String seat) throws Exception;
	// public void UpdateSeatStatus_Cancel(String[] Time); // 경진이가 짜면 추가
}


