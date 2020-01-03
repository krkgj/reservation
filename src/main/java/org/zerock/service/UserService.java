package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.ReservationVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

public interface UserService {

  public UserVO login(LoginDTO dto) throws Exception;

  //public void keepLogin(String uid, String sessionId, Date next)throws Exception;
  
  public UserVO checkLoginBefore(String value);

public List<UserVO> membership()  throws Exception;

<<<<<<< HEAD
void memberDelete(String unumber) throws Exception;

void UserCancelAction(String uname);

ReservationVO usercancel(String uname);  

// public ReservationVO usercancel(String uname);
=======
void memberDelete(String unumber) throws Exception;  
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
}
