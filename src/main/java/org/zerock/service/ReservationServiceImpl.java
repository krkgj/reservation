package org.zerock.service;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.zerock.converter.DateToStringConverter;
import org.zerock.converter.StringToDateConverter;
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
	public void updateSeatStatus(SeatVO svo)
	{
		rdao.updateSeatStatus(svo);
	}
	
	@Override
	public int UserDuplicateCheck(String uname) // ������ �� ����ڰ� �̹� ������ ���̺� �����ϴ��� ���ϴ��� �˻��ϴ� �ڵ��Դϴ�.
	{
		return rdao.UserDuplicateCheck(uname);
	}
	
	 
	   
	  @Override
	  public SeatVO compareSeatStatus(String[] reservationTime, SeatVO svo)
	  {
		  for(int i = 0; i<reservationTime.length; i++) // reservationTime�� ���̸�ŭ �ݺ����� ���� �ð��� �ش��ϴ� �ʵ��� ���� 1�� ����.
	      {
	         System.out.println(reservationTime[i]);
	         
	         if(reservationTime[i].equals("09:00:00"))
	         {
	            System.out.println("9��");
	            svo.setNineToTen(1);
	         }
	         else if(reservationTime[i].equals("10:00:00"))
	         {
	            System.out.println("10��");
	            svo.setTenToEleven(1);
	         }
	         else if(reservationTime[i].equals("11:00:00"))
	         {
	            System.out.println("11��");
	            svo.setElevenToTwelve(1);
	         }
	         else if(reservationTime[i].equals("12:00:00"))
	         {
	            System.out.println("12��");
	            svo.setTwelveThirteen(1);
	         }
	         else if(reservationTime[i].equals("13:00:00"))
	         {
	            System.out.println("13��");
	            svo.setThirteenToFourteen(1);
	         }
	         else if(reservationTime[i].equals("14:00:00"))
	         {
	            System.out.println("14��");
	            svo.setFourteenToFifteen(1);
	         }
	         else if(reservationTime[i].equals("15:00:00"))
	         {
	            System.out.println("15��");
	            svo.setFifteenToSixteen(1);
	         }
	         else if(reservationTime[i].equals("16:00:00"))
	         {
	            System.out.println("16��");
	            svo.setSixteenToSeventeen(1);
	         }
	         else if(reservationTime[i].equals("17:00:00"))
	         {
	            System.out.println("17��");
	            svo.setSeventeenToEightteen(1);
	         }
	         else if(reservationTime[i].equals("18:00:00"))
	         {
	            System.out.println("18��");
	            svo.setEightteenToNineteen(1);
	         }
	         else if(reservationTime[i].equals("19:00:00"))
	         {
	            System.out.println("19��");
	            svo.setNineteenToTwenty(1);
	         }
	         else if(reservationTime[i].equals("20:00:00"))
	         {
	            System.out.println("20��");
	            svo.setTwentyToTwentyOne(1);
	         }
	         else if(reservationTime[i].equals("21:00:00"))
	         {
	            System.out.println("21��");
	            svo.setTwentyOneToTwentyTwo(1);
	         }
	      }
		  
		  return svo;
	  }
	  
	  @Override
	  public ReservationVO useConvert(String[] reservationTime, HttpSession session, ReservationVO rvo, String uname, String unumber, String seat) throws Exception
	  {
		  DateToStringConverter dtsconverter = new DateToStringConverter();
	      StringToDateConverter stdconverter = new StringToDateConverter();
	      
	      Date reserveStartTime = new Date();
	      Date reserveEndTime = new Date();
	      
		  if (reservationTime.length == 1) { 
	    	  reservationTime[0] = dtsconverter.datetostringConverter(reserveStartTime) + " " + reservationTime[0];
	    	  
	    	  reserveStartTime = stdconverter.stringtodateConverter(reservationTime[0]);
	    	  reserveEndTime = stdconverter.stringtodateConverter(reservationTime[0]); 
	        } else { 
	        	reservationTime[0] = dtsconverter.datetostringConverter(reserveStartTime) + " " + reservationTime[0];
	        
	        	for (int i = 1; i < reservationTime.length; i++) { 
	        		reservationTime[1] = reservationTime[i]; 
	        	}
	        
	        	reservationTime[1] = dtsconverter.datetostringConverter(reserveStartTime) + " " + reservationTime[1];
	        
	        	reserveStartTime = stdconverter.stringtodateConverter(reservationTime[0]);
	        	reserveEndTime = stdconverter.stringtodateConverter(reservationTime[1]); 
	        }
		  
		  rvo.setUname(uname); rvo.setUnumber(unumber); rvo.setSeat(seat);
	        rvo.setReserveStartTime(reserveStartTime);
	        rvo.setReserveEndTime(reserveEndTime);
	        
	        System.out.println("������ �̸�: " + uname); 
	        System.out.println("������ �й� : " + unumber); 
	        System.out.println("���� ���� �ð� : " + rvo.getReserveStartTime());
	        System.out.println("���� ���� �ð� + 1 : " + rvo.getReserveEndTime());
	        System.out.println("���� �¼� : " + rvo.getSeat());
	        
	        session.setAttribute("reserveStartTime", reserveStartTime);
	        session.setAttribute("reserveEndTime", reserveEndTime);
	        session.setAttribute("seat", seat);
	        
	        return rvo;
	  }
//	  @Override // �����̰� ¥�� �߰�
//	  public void UpdateSeatStatus_Cancel(String[] Time) {
//		  rdao.UpdateSeatStatus_Cancel(Time);
//	  }
	  
}