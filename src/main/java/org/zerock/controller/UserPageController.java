package org.zerock.controller;

<<<<<<< HEAD

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
=======
import java.io.DataOutputStream;
import java.io.IOException;   
import java.io.OutputStream;  
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.ReservationService;
import org.zerock.service.UserService;

import com.google.gson.Gson; 

@Controller
@RequestMapping("/sysview/*")
public class UserPageController {


	@Inject
	ReservationService Rservice;
	
	@Inject
    UserService Uservice;
    
	@RequestMapping(value = "/caution", method = RequestMethod.GET)
	public String caution(@ModelAttribute("dto") LoginDTO dto, HttpSession session) {

		String name = (String) session.getAttribute("uname");
		try {
			if (name ==(null)) {
				return "/sysview/wrongAccess";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "/sysview/wrongAccess";
		}
		return "/sysview/caution";
	}

	@RequestMapping(value = "/seat", method = RequestMethod.GET)
	public String reservationSeat(Model model, LoginDTO dto, HttpSession session)

	{
		String name = (String) session.getAttribute("uname");
		try {
			if (name ==(null)) {
				return "/sysview/wrongAccess";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "/sysview/wrongAccess";
		}
		return "/sysview/seat";
	}
	
	@RequestMapping(value = "/room", method = RequestMethod.GET)
	public String reservationRoom(Model model, LoginDTO dto, HttpSession session)

	{
		String name = (String) session.getAttribute("uname");
		try {
			if (name ==(null)) {
				return "/sysview/wrongAccess";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "/sysview/wrongAccess";
		}	
		return "/sysview/room";
	}
	

	
	@RequestMapping(value = "/wrongAccess", method = RequestMethod.GET)
	public void access(ReservationVO vo, HttpSession session, Model model) {

	}
	
	// 라디오 버튼을 클릭할 때마다 각 좌석의 시간대별 얘약현황을 보여주기 위한 코드입니다. 
	@RequestMapping(value = "/status/{seat}", method = RequestMethod.GET)
	@ResponseBody  // 컨트롤러단에서 보낼 리턴값을 Success쪽으로 맵핑시키기 위해 사용합니다.
	public String SeatStatus(@PathVariable("seat") String seat, Model model, HttpSession session) {
			
			SeatVO VO = Rservice.SeatStatus(seat); 
			String [] a= new String[13];
		  				
			a[0]=VO.getNineToTen().toString();
			a[1]=VO.getTenToEleven().toString();
			a[2]=VO.getElevenToTwelve().toString();
			a[3]=VO.getTwelveThirteen().toString();
			a[4]=VO.getThirteenToFourteen().toString();
			a[5]=VO.getFourteenToFifteen().toString();
			a[6]=VO.getFifteenToSixteen().toString();
			a[7]=VO.getSixteenToSeventeen().toString();
			a[8]=VO.getSeventeenToEightteen().toString();
			a[9]=VO.getEightteenToNineteen().toString();
			a[10]=VO.getNineteenToTwenty().toString();
			a[11]=VO.getTwentyToTwentyOne().toString();
			a[12]=VO.getTwentyOneToTwentyTwo().toString();
			
			 Gson gson = new Gson(); 
<<<<<<< HEAD
			 String test = gson.toJson(a); 

		return test; 
	}
	
	// 스터디룸 예약 페이지에 접속 할 때 스터디룸의 시간대별 예약현황을 보여주기 위한 코드입니다.
	@RequestMapping(value = "/roomstatus/{room}", method = RequestMethod.GET)
	@ResponseBody
	public String RoomStatus(@PathVariable("room") String Rno,Model model, LoginDTO dto, HttpSession session) {
		System.out.println("호출되었습니다"); 
		SeatVO VO = Rservice.SeatStatus(Rno); // SeatVO 형 객체 VO 에  스터디룸의 시간대별 예약현황 키값들이 담겨있다.
		String [] a= new String[13];
			
		a[0]=VO.getNineToTen().toString();
		a[1]=VO.getTenToEleven().toString();
		a[2]=VO.getElevenToTwelve().toString();
		a[3]=VO.getTwelveThirteen().toString();
		a[4]=VO.getThirteenToFourteen().toString();
		a[5]=VO.getFourteenToFifteen().toString();
		a[6]=VO.getFifteenToSixteen().toString();
		a[7]=VO.getSixteenToSeventeen().toString();
		a[8]=VO.getSeventeenToEightteen().toString();
		a[9]=VO.getEightteenToNineteen().toString();
		a[10]=VO.getNineteenToTwenty().toString();
		a[11]=VO.getTwentyToTwentyOne().toString();
		a[12]=VO.getTwentyOneToTwentyTwo().toString();
		
		 Gson gson = new Gson(); 
		 String test = gson.toJson(a); 
		 System.out.println(test);
	return test; 
=======
			 String test = gson.toJson(a);
		return test; 
	}
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public void showUserInfo(HttpSession session, Model model)
	{
		
		  Date reserveStartTime = (Date)session.getAttribute("reserveStartTime");
		  Date reserveEndTime = (Date)session.getAttribute("reserveEndTime");
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			
		  String rST = formatter.format(reserveStartTime);
		  String rET = formatter.format(reserveEndTime);
		  
		  model.addAttribute("reserveStartTime", rST);
		  model.addAttribute("reserveEndTime", rET);
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
	}
	
	@RequestMapping(value = "showuserinfo", method = RequestMethod.GET)
	public void showUserInfo()
	{
		
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "usercancel", method = RequestMethod.GET) // 사용자 예약취소페이지 
	public String cancel(HttpSession session,Model model)
	{
		String name = (String) session.getAttribute("uname");
		try {
			if (name ==(null)) {
				return "/sysview/wrongAccess";
			}

		} catch (Exception e) {
			return "/sysview/wrongAccess";
		}
		
		ReservationVO VO =  Uservice.usercancel(name); // 예약내역이 없는 사용자가 예약취소페이지에 접근 시 알람창을 띄어주며 접근불가하게 만듭니다.
		if(VO == null) {
			return "/sysview/UserCancelWrongAccess";
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm"); // DB에서 받은 예약 시작,끝 시간을 우리가 원하는 형식대로 출력하기위해  포맷형식을 바꿨습니다. 
		String StartTime = format1.format(VO.getReserveStartTime());
		String EndTime = format1.format(VO.getReserveEndTime());
			
		model.addAttribute("Username", VO.getUname());
		model.addAttribute("Usernumber", VO.getUnumber());
		model.addAttribute("reserveStartTime",StartTime);
		model.addAttribute("reserveEndTime", EndTime);
		model.addAttribute("seat", VO.getSeat());
		
		session.setAttribute("seat", VO.getSeat());
		
		return "/sysview/usercancel";
	}
		
	@RequestMapping(value = "/UserCancelAction/{Username}", method = RequestMethod.GET)  // 사용자 예약취소기능 구현 
	public String UserCancelAction(@PathVariable("Username") String uname, HttpSession session) throws Exception
	{
		int[] hours = new int[5];
		int i = 2;
		String seat = (String)session.getAttribute("seat");
		ReservationVO VO =  Uservice.usercancel(uname); // reservation 테이블에서 uname에 해당하는 정보를 갖고온다
		
		Calendar startCal = Calendar.getInstance(); // Calendar 객체를 생성합니다.
		startCal.setTime(VO.getReserveStartTime()); // Calendar 객체로 VO의 ReserveStartTime 객체를 받음
		hours[0] = startCal.get(Calendar.HOUR_OF_DAY); // HOUR_OF_DAY(24시간표시)로 startCal에 저장되어있던 데이터를 hours[0]에 할당합니다. -> int를 리턴하기 때문
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(VO.getReserveEndTime());
		endCal.add(Calendar.HOUR_OF_DAY, -1); // 끝 시간에서 -1시간 해야함.
		hours[1] = endCal.get(Calendar.HOUR_OF_DAY);
		System.out.println(hours[1]);
		
		while(i < 5) // hours[0]과 [1]에는 StartTime과 EndTime이 각각 저장되어있기 때문에 i는 2부터 시작해야함.
		{
			startCal.add(Calendar.HOUR_OF_DAY, 1); // StartTime을 기준으로 1시간씩 더한다.
			System.out.println(startCal.get(Calendar.HOUR_OF_DAY));
			hours[i] = startCal.get(Calendar.HOUR_OF_DAY);
			
			if(hours[i] == hours[1]) // StartTime에서 1시간씩 더하다가, hours[1], 즉 EndTime과 같아지는 순간 break 처리
			{
				break;
			}
			i++; // 2,3,4.... 순으로 시간을 저장함
		}
		
		SeatVO svo = Rservice.SeatStatus(seat); // seat에 해당하는 좌석의 상태를 받아서 svo 객체에 할당

	      for(int j = 0; j<hours.length; j++) // hours의 길이만큼 반복문을 통해 시간에 해당하는 필드 값 0으로 설정
	      {
	         System.out.println(hours[j]);
	         
	         if(hours[j] == 9)
	         {
	            svo.setNineToTen(0);
	         }
	         else if(hours[j] == 10)
	         {
	            svo.setTenToEleven(0);
	         }
	         else if(hours[j] == 11)
	         {
	        	 svo.setElevenToTwelve(0);
	         }
	         else if(hours[j] == 12)
	         {
	            svo.setTwelveThirteen(0);
	         }
	         else if(hours[j] == 13)
	         {
	            svo.setThirteenToFourteen(0);
	         }
	         else if(hours[j] == 14)
	         {
	            svo.setFourteenToFifteen(0);
	         }
	         else if(hours[j] == 15)
	         {
	            svo.setFifteenToSixteen(0);
	         }
	         else if(hours[j] == 16)
	         {
	            svo.setSixteenToSeventeen(0);
	         }
	         else if(hours[j] == 17)
	         {
	            svo.setSeventeenToEightteen(0);
	         }
	         else if(hours[j] == 18)
	         {
	            svo.setEightteenToNineteen(0);
	         }
	         else if(hours[j] == 19)
	         {
	            svo.setNineteenToTwenty(0);
	         }
	         else if(hours[j] == 20)
	         {
	            svo.setTwentyToTwentyOne(0);
	         }
	         else if(hours[j] == 21)
	         {
	            svo.setTwentyOneToTwentyTwo(0);
	         }
	      }
		Rservice.updateSeatStatus(svo); // Rservice의 updateSeatStatus를 통해 맵퍼를 호출한다.

	    System.out.println("Uservice 호출전");
		Uservice.UserCancelAction(uname); // 예약취소하는 서비스 호출	
		
		
		return "/sysview/UserCancelSuccess"; // 예약이 정상적으로 취소 될시에 알람창을 띄어주며 caution 페이지로 보내줍니다.
	}

=======
	 
  
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
}
