package org.zerock.visitcounter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zerock.domain.VisitcountVO;
import org.zerock.persistence.VisitCountDAO;
import org.zerock.persistence.VisitCountDAOImpl;

public class VisitCounter implements HttpSessionListener{
	
    @Override
    public void sessionCreated(HttpSessionEvent arg0){
    	
        HttpSession session = arg0.getSession();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
        //등록되어있는 빈을 사용할수 있도록 설정해준다
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        //request를 파라미터에 넣지 않고도 사용할수 있도록 설정
        VisitCountDAOImpl visitCountDAO = (VisitCountDAOImpl)wac.getBean("visitCountDAO"); // 등록된 Bean을 사용한다.
        VisitcountVO vo = new VisitcountVO();
        vo.setVisit_ip(req.getRemoteAddr()); // 사용자의 ip를 set
        vo.setVisit_agent(req.getHeader("User-Agent"));//브라우저 정보
        vo.setVisit_refer(req.getHeader("referer"));//접속 전 사이트 정보
        visitCountDAO.insertVisitor(vo); // 처음 접속한 사용자의 정보(ip, agent..)를 db에 입력한다.
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0){
        //TODO Auto-generated method stub
    }
}