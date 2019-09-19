package com.exam.test.dao;

import com.exam.test.model.UserVO;

public interface UserDAO {
	public UserVO getUser(String identifier) throws Exception;
	public boolean signup(UserVO userVO) throws Exception;
	public UserVO getMyInfo(int _id) throws Exception;
}
