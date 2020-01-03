package org.zerock.persistence;

import java.util.Date;
import java.util.List;

import org.zerock.domain.ReservationVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto)throws Exception;

	/* public void keepLogin(String uid, String sessionId, Date next); */
  
  public UserVO checkUserWithSessionKey(String value);

List<UserVO> membership() throws Exception;

void memberDelete(String unumber) throws Exception;

<<<<<<< HEAD
void UserCancelAction(String uname);

ReservationVO UserCancel(String uname);

//public ReservationVO UserCancel(String uname); 
=======
  
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
}



