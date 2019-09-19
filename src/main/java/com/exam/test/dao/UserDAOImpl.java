package com.exam.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.test.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public UserVO getUser(String identifier) throws Exception {
		return sqlSession.selectOne("userMapper.getUser", identifier);
	}

	@Override
	public boolean signup(UserVO userVO){
		try {
			sqlSession.insert("userMapper.insertUser",userVO);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public UserVO getMyInfo(int _id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("userMapper.getMyInfo",_id);
	}

}
