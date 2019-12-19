package org.zerock.persistence;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;

public interface ReservationDAO {

	public void reservationSeat(ReservationVO rvo);
	public int duplicateCheck(ReservationVO rvo);
	public SeatVO SeatStatus(String sno);
	public void updateSeatStatus(SeatVO svo);
}
