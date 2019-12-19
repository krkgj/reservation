package org.zerock.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
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
  
  /* Ãß°¡ */
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
  

}
