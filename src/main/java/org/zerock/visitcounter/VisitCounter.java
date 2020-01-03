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
        //��ϵǾ��ִ� ���� ����Ҽ� �ֵ��� �������ش�
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        //request�� �Ķ���Ϳ� ���� �ʰ� ����Ҽ� �ֵ��� ����
        VisitCountDAOImpl visitCountDAO = (VisitCountDAOImpl)wac.getBean("visitCountDAO"); // ��ϵ� Bean�� ����Ѵ�.
        VisitcountVO vo = new VisitcountVO();
        vo.setVisit_ip(req.getRemoteAddr()); // ������� ip�� set
        vo.setVisit_agent(req.getHeader("User-Agent"));//������ ����
        vo.setVisit_refer(req.getHeader("referer"));//���� �� ����Ʈ ����
        visitCountDAO.insertVisitor(vo); // ó�� ������ ������� ����(ip, agent..)�� db�� �Է��Ѵ�.
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0){
        //TODO Auto-generated method stub
    }
}