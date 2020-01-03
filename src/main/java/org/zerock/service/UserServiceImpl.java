package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;
import org.zerock.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  private UserDAO dao;

  @Override
  public UserVO login(LoginDTO dto) throws Exception {

    return dao.login(dto);
  }
  
  @Override
  public UserVO checkLoginBefore(String value) {
    
    return dao.checkUserWithSessionKey(value);
  }
  
  @Override
  public List<UserVO> membership() throws Exception {
     return dao.membership();
  }

  @Override
  public void memberDelete(String unumber) throws Exception{
     dao.memberDelete(unumber);
  }
<<<<<<< HEAD
  
  @Override
  public ReservationVO usercancel(String uname) { // �������̺� ���� ������ ������� �̸��� �����ϴ��� �˻�
	  return dao.UserCancel(uname);
  }
  
  @Override
  public void UserCancelAction(String uname) {
	  dao.UserCancelAction(uname);
  }
  
//  @Override
//  public ReservationVO usercancel(String uname) { // �������̺� ���� ������ ������� �̸��� �����ϴ��� �˻�
//	  System.out.println("USER cancel ���� ȣ��!");
//	  return dao.UserCancel(uname);
//  }
=======
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
}
