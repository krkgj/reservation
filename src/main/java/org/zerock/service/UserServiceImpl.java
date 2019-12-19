package org.zerock.service;

import java.util.Date;

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
}
