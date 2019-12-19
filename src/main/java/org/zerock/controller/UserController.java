package org.zerock.controller;

import java.util.Date;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.POST)
	public String loginError(LoginDTO dto, HttpSession session, Model model) throws Exception {

		UserVO vo = service.login(dto);
		try {
			if(vo.getUname().equals("admin"))
			{
				session.setAttribute("admin", vo.getUname());
				model.addAttribute("adminVO", vo);
				
				System.out.println(vo.getUname());
				return "/admin/admin";
			}
			else
			{
				session.setAttribute("uname", vo.getUname());
				session.setAttribute("unumber", vo.getUnumber());
				model.addAttribute("userVO", vo);
			}
		}catch (Exception e) {
			// TODO: handle exception
				return "/user/loginError";
		}
		return "redirect:/sysview/caution";
	}
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public void logoutPost(ReservationVO vo, HttpSession session, Model model)
	 {
	     session.invalidate();
	 }
}
