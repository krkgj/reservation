package org.zerock.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace ="org.zerock.mapper.UserMapper";	

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return session.selectOne(namespace +".login", dto);
	}
	
  @Override
  public UserVO checkUserWithSessionKey(String value) {

    return session.selectOne(namespace +".checkUserWithSessionKey", value);
  }	
  
  /* 추가 */
  @Override
  public List<UserVO> membership() throws Exception {
     // TODO Auto-generated method stub
  return session.selectList(namespace +".membership");
  }
   
  @Override
  public void memberDelete(String unumber) throws Exception {
     // TODO Auto-generated method stub
   session.delete(namespace + ".memberDelete", unumber);
  }
  
  @Override
  public ReservationVO UserCancel(String uname) { // 예약테이블에 현재 접속한 사용자의 이름이 존재하는지 검사
     return session.selectOne(namespace + ".usercancel", uname);
  }
  
  @Override
  public void UserCancelAction(String uname) {
     session.selectOne(namespace + ".UserCancelAction", uname);
  }
  
  
//	@Override
//	public ReservationVO UserCancel(String uname) { // 예약테이블에 현재 접속한 사용자의 이름이 존재하는지 검사
//		System.out.println("USER dao 호출!");
//		return session.selectOne(namespace + ".usercancel", uname);
//	
//	}

}
