package org.zerock.controller;


import java.io.DataOutputStream;
import java.io.IOException;   
import java.io.OutputStream;  
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.SeatVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.ReservationService;

import com.google.gson.Gson; 

@Controller
@RequestMapping("/sysview/*")
public class UserPageController {


	@Inject
	private ReservationService service;

	@RequestMapping(value = "/caution", method = RequestMethod.GET)
	public String caution(@ModelAttribute("dto") LoginDTO dto, HttpSession session) {

		String name = (String) session.getAttribute("uname");
		try {
			if (name.equals(null)) {
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
			if (name.equals(null)) {
				return "/sysview/wrongAccess";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "/sysview/wrongAccess";
		}
		return "/sysview/seat";

	}

	@RequestMapping(value = "/wrongAccess", method = RequestMethod.GET)
	public void access(ReservationVO vo, HttpSession session, Model model) {

	}

	@RequestMapping(value = "/status/{seat}", method = RequestMethod.GET)
	@ResponseBody
	public String SeatStatus(@PathVariable("seat") String seat, Model model, HttpSession session) {
		System.out.println("status : " + seat ); 
			
			SeatVO VO = service.SeatStatus(seat); 
			String [] a= new String[13];
		  		 
			a[0]=VO.getNineToTen().toString();
			a[1]=VO.getTenToEleven().toString();
			a[2]=VO.getElevenToTwelve().toString();
			a[3]=VO.getTwelveThirteen().toString();
;			a[4]=VO.getThirteenToFourteen().toString();
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
		return test; 
	}
	
	@RequestMapping(value = "/showuserinfo", method = RequestMethod.GET)
	public void showUserInfo()
	{
		
	}
	
	
	 
	  @RequestMapping(value = "/test", method = RequestMethod.GET)
	  public void test(ReservationVO vo, HttpSession session, Model model) {			  		  
		  int certNumLength = 8;
		  
		  Random random = new Random(System.currentTimeMillis());
		  
		  
	        int range = (int)Math.pow(10,certNumLength);
	        int trim = (int)Math.pow(10, certNumLength-1);
	        int result = random.nextInt(range)+trim;
	         
	        if(result>range){
	            result = result - trim;
	        }
	        session.setAttribute("qrcode",String.valueOf(result));
	        System.out.println("발생한 난수? : "+String.valueOf(result));
	        
	        ServerSocket server_socket = null; 
	        Socket socket = null; 
	        
	        try{
	            server_socket = new ServerSocket(8080);	            
	        }catch(IOException e){
	            System.out.println("123123");
	        }
	        try {
	        	socket = server_socket.accept();   
	        	 OutputStream out = socket.getOutputStream(); 
	        	 DataOutputStream dos = new DataOutputStream(out);
	        	 dos.writeUTF(String.valueOf(result));
	        	 dos.close();
	        }catch(IOException e){}	        
	  }		  
}
