package org.zerock.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.converter.DateToStringConverter;
import org.zerock.converter.StringToDateConverter;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;
import org.zerock.dto.ReservationDTO;
import org.zerock.service.ReservationServiceImpl;

@Controller
@RequestMapping("/reservation/*")
public class ReservationController {

   @Inject
   private ReservationServiceImpl rservice;
   

   
   @RequestMapping(value = "/reservation", method = RequestMethod.POST)
   public void doReservation(ReservationDTO dto, HttpSession session, Model model) throws Exception {
      
      ReservationVO rvo = new ReservationVO();
      SeatVO svo = new SeatVO();
      String uname = (String) session.getAttribute("uname");
      String unumber = (String) session.getAttribute("unumber");
      String seat = dto.getSeat();

      Date reserveStartTime = new Date();
      Date reserveEndTime = new Date();

      DateToStringConverter dtsconverter = new DateToStringConverter();
      StringToDateConverter stdconverter = new StringToDateConverter();

      String[] reservationTime = dto.getReservateTime();
      
      for(int i = 0; i<reservationTime.length; i++)
      {
         System.out.println(reservationTime[i]);
         
         if(reservationTime[i].equals(" 09:00:00"))
         {
            System.out.println("9시");
            svo.setNineToTen(1);
         }
         else if(reservationTime[i].equals(" 10:00:00"))
         {
            System.out.println("10시");
            svo.setTenToEleven(1);
         }
         else if(reservationTime[i].equals(" 11:00:00"))
         {
            System.out.println("11시");
            svo.setElevenToTwelve(1);
         }
         else if(reservationTime[i].equals(" 12:00:00"))
         {
            System.out.println("12시");
            svo.setTwelveThirteen(1);
         }
         else if(reservationTime[i].equals(" 13:00:00"))
         {
            System.out.println("13시");
            svo.setThirteenToFourteen(1);
         }
         else if(reservationTime[i].equals(" 14:00:00"))
         {
            System.out.println("14시");
            svo.setFourteenToFifteen(1);
         }
         else if(reservationTime[i].equals(" 15:00:00"))
         {
            System.out.println("15시");
            svo.setFifteenToSixteen(1);
         }
         else if(reservationTime[i].equals(" 16:00:00"))
         {
            System.out.println("16시");
            svo.setSixteenToSeventeen(1);
         }
         else if(reservationTime[i].equals(" 17:00:00"))
         {
            System.out.println("17시");
            svo.setSeventeenToEightteen(1);
         }
         else if(reservationTime[i].equals(" 18:00:00"))
         {
            System.out.println("18시");
            svo.setEightteenToNineteen(1);
         }
         else if(reservationTime[i].equals(" 19:00:00"))
         {
            System.out.println("19시");
            svo.setNineteenToTwenty(1);
         }
         else if(reservationTime[i].equals(" 20:00:00"))
         {
            System.out.println("20시");
            svo.setTwentyToTwentyOne(1);
         }
         else if(reservationTime[i].equals(" 21:00:00"))
         {
            System.out.println("21시");
            svo.setTwentyOneToTwentyTwo(1);
         }
      }
      
        if (reservationTime.length == 1) { reservationTime[0] =
        dtsconverter.datetostringConverter(reserveStartTime) + " " +
        reservationTime[0];
        
        reserveStartTime = stdconverter.stringtodateConverter(reservationTime[0]);
        reserveEndTime = stdconverter.stringtodateConverter(reservationTime[0]); }
        else { reservationTime[0] =
        dtsconverter.datetostringConverter(reserveStartTime) + reservationTime[0];
        
        for (int i = 1; i < reservationTime.length; i++) { reservationTime[1] =
        reservationTime[i]; } reservationTime[1] =
        dtsconverter.datetostringConverter(reserveStartTime) + reservationTime[1];
        
        reserveStartTime = stdconverter.stringtodateConverter(reservationTime[0]);
        reserveEndTime = stdconverter.stringtodateConverter(reservationTime[1]); }
       
      
        rvo.setUname(uname); rvo.setUnumber(unumber); rvo.setSeat(seat);
        rvo.setReserveStartTime(reserveStartTime);
        rvo.setReserveEndTime(reserveEndTime);
        
        System.out.println("예약자 이름: " + uname); 
        System.out.println("예약자 학번 : " + unumber); 
        System.out.println("예약 시작 시간 : " + rvo.getReserveStartTime());
        System.out.println("예약 종료 시간 + 1 : " + rvo.getReserveEndTime());
        System.out.println("예약 좌석 : " + rvo.getSeat());
        
        
        int result = rservice.duplicateCheck(rvo);
        
        if(result == 0) { 
           rservice.reservationSeat(rvo);
        
		}
   }

}