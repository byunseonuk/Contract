package com.exam.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.test.dao.UserDAO;
import com.exam.test.model.AuthInfoVO;
import com.exam.test.model.LoginVO;
import com.exam.test.model.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public boolean checkID(String identifier) throws Exception {

		UserVO userVO = userDAO.getUser(identifier);
		if(userVO!=null) {
			return false;
		}
		return true;
	}

	@Override
	public AuthInfoVO login(LoginVO loginVO) throws Exception {
		UserVO userVO = userDAO.getUser(loginVO.getIdentifier());
		if(userVO!=null) {
			if(bcryptPasswordEncoder.matches(loginVO.getPassword(), userVO.getPassword())) {
				return new AuthInfoVO(	userVO.get_id(),
										userVO.getIdentifier(),
										userVO.getName(),
										userVO.getEmail(),
										userVO.getPhone(),
										userVO.getRole());
				
			}
		}
		return null;
	}

	@Override
	public boolean signup(UserVO userVO) throws Exception {
		userVO.setPassword(bcryptPasswordEncoder.encode(userVO.getPassword()));
		if(userDAO.signup(userVO))
			return true;
		return false;
	}

	@Override
	public UserVO getMyInfo(int _id) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.getMyInfo(_id);
	}

}
