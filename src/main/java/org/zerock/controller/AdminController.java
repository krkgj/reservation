package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Inject
	private UserService service;
	
	@RequestMapping("/admin")
	public String admin(HttpSession session)
	{
		 String name = (String)session.getAttribute("admin");
		  try {
			  if(name.equals(null))
			  {
				  return "/sysview/wrongAccess";
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/sysview/wrongAccess";
		}
		  
		return "/admin/admin";
	}
	
	@RequestMapping("/cancel")
	public String cancelReserve(HttpSession session)
	{
		 String name = (String)session.getAttribute("admin");
		  try {
			  if(name.equals(null))
			  {
				  return "/sysview/wrongAccess";
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/sysview/wrongAccess";
		}
		  
		return "/admin/admin";
	}
	
	/*
	 * @RequestMapping("/membership") public String memberModify(HttpSession
	 * session) { String name = (String)session.getAttribute("admin"); try {
	 * if(name.equals(null)) { return "/sysview/wrongAccess"; }
	 * 
	 * } catch (Exception e) { // TODO: handle exception return
	 * "redirect:/sysview/wrongAccess"; }
	 * 
	 * return "/admin/admin"; }
	 */
	

	   @RequestMapping("/membership")
	   public String membership(Model model, HttpSession session) throws Exception 
	   {
	      List<UserVO> list = service.membership();   
	      session.setAttribute("sessionList", list);
	      model.addAttribute("list", list);
	      
	      return "/admin/membership";
	   }
	   
	   /* 삭제 */
	   @RequestMapping(value = "/memberDelete/{unumber}", method = RequestMethod.GET)
	   public String memberDelete(@PathVariable String unumber) throws Exception
	   {
	      System.out.println(unumber);
	      service.memberDelete(unumber);
	      System.out.println("삭제되었습니다");
	      
	      return "redirect:/admin/membership";
	   }
	
	
}
