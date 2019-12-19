package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

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
	
	@RequestMapping("/membership")
	public String memberModify(HttpSession session)
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
	
	
	
	
}
