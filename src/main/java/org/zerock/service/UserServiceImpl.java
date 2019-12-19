package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
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
}
