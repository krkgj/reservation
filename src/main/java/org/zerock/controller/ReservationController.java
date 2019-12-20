package org.zerock.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
      
      System.out.println(reserveStartTime);

      DateToStringConverter dtsconverter = new DateToStringConverter();
      StringToDateConverter stdconverter = new StringToDateConverter();

      String[] reservationTime = dto.getReservateTime();
      System.out.println(reservationTime[0]);
      System.out.println(reservationTime.length);
      
      
      svo = rservice.SeatStatus(seat); // seat에 해당하는 좌석의 상태를 받아서 svo 객체에 할당
      for(int i = 0; i<reservationTime.length; i++) // reservationTime의 길이만큼 반복문을 통해 시간에 해당하는 필드의 값을 1로 설정.
      {
         System.out.println(reservationTime[i] + " in for문");
         
         if(reservationTime[i].equals("09:00:00"))
         {
            System.out.println("9시");
            svo.setNineToTen(1);
         }
         else if(reservationTime[i].equals("10:00:00"))
         {
            System.out.println("10시");
            svo.setTenToEleven(1);
         }
         else if(reservationTime[i].equals("11:00:00"))
         {
            System.out.println("11시");
            svo.setElevenToTwelve(1);
         }
         else if(reservationTime[i].equals("12:00:00"))
         {
            System.out.println("12시");
            svo.setTwelveThirteen(1);
         }
         else if(reservationTime[i].equals("13:00:00"))
         {
            System.out.println("13시");
            svo.setThirteenToFourteen(1);
         }
         else if(reservationTime[i].equals("14:00:00"))
         {
            System.out.println("14시");
            svo.setFourteenToFifteen(1);
         }
         else if(reservationTime[i].equals("15:00:00"))
         {
            System.out.println("15시");
            svo.setFifteenToSixteen(1);
         }
         else if(reservationTime[i].equals("16:00:00"))
         {
            System.out.println("16시");
            svo.setSixteenToSeventeen(1);
         }
         else if(reservationTime[i].equals("17:00:00"))
         {
            System.out.println("17시");
            svo.setSeventeenToEightteen(1);
         }
         else if(reservationTime[i].equals("18:00:00"))
         {
            System.out.println("18시");
            svo.setEightteenToNineteen(1);
         }
         else if(reservationTime[i].equals("19:00:00"))
         {
            System.out.println("19시");
            svo.setNineteenToTwenty(1);
         }
         else if(reservationTime[i].equals("20:00:00"))
         {
            System.out.println("20시");
            svo.setTwentyToTwentyOne(1);
         }
         else if(reservationTime[i].equals("21:00:00"))
         {
            System.out.println("21시");
            svo.setTwentyOneToTwentyTwo(1);
         }
      }
      rservice.updateSeatStatus(svo);
      
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
      
        rvo.setUname(uname); 
        rvo.setUnumber(unumber); 
        rvo.setSeat(seat);
        rvo.setReserveStartTime(reserveStartTime);
        rvo.setReserveEndTime(reserveEndTime);
        
        System.out.println("예약자 이름: " + uname); 
        System.out.println("예약자 학번 : " + unumber); 
        System.out.println("예약 시작 시간 : " + rvo.getReserveStartTime());
        System.out.println("예약 종료 시간 + 1 : " + rvo.getReserveEndTime());
        System.out.println("예약 좌석 : " + rvo.getSeat());
        
        session.setAttribute("reserveStartTime", reserveStartTime);
        session.setAttribute("reserveEndTime", reserveEndTime);
        
        
        rservice.reservationSeat(rvo);
        
        int certNumLength = 8;
        
        Random random = new Random(System.currentTimeMillis());
                  
           int range = (int)Math.pow(10,certNumLength);
           int trim = (int)Math.pow(10, certNumLength-1);
           int QRresult = random.nextInt(range)+trim;
            
           if(QRresult>range){
              QRresult = QRresult - trim;
           }
        session.setAttribute("qrcode",String.valueOf(QRresult)); // 난수를 발생시켜 "qrcode" 라는 이름으로 session 에 저장하고 있습니다.
        System.out.println("발생한 난수 : " + QRresult);
                 
       
      
      
//        try{
//        Socket sock = new Socket("220.68.231.110", 10001);
//        
//        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//        
//        OutputStream out = sock.getOutputStream();
//        
//        InputStream in = sock.getInputStream();
//        
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        
//        String line = null;
//        
//        line = String.valueOf(QRresult);
//        
//        pw.println(line); 
//        pw.flush(); 
//        String echo = br.readLine();
//        
//        System.out.println("서버로 보낸 난수 :" + echo);
//        
//        pw.close(); 
//        br.close(); 
//        sock.close();
//        
//        } 
//        catch(Exception e){ 
//           System.out.println(e); 
//           }
   }

}