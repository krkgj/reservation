package org.zerock.persistence;

import java.util.Date;
import java.util.List;

import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto)throws Exception;

	/* public void keepLogin(String uid, String sessionId, Date next); */
  
  public UserVO checkUserWithSessionKey(String value);

List<UserVO> membership() throws Exception;

void memberDelete(String unumber) throws Exception;

  
}



