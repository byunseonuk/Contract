package com.exam.test.service;

import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.LoginVO;
import com.exam.test.model.UserVO;

public interface UserService {
	public boolean checkID(String identifier) throws Exception;
	public AuthInfoVO login(LoginVO loginVO) throws Exception;
	public boolean signup(UserVO userVO) throws Exception;
	public UserVO getMyInfo(int _id) throws Exception;
}
