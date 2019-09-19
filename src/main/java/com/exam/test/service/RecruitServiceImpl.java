package com.exam.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.test.dao.RecruitDAO;
import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.CareerVO;
import com.exam.test.model.CertificateVO;
import com.exam.test.model.LanguageVO;
import com.exam.test.model.RecruitThumbVO;
import com.exam.test.model.RecruitmentVO;
import com.exam.test.model.ResumeVO;

@Service
public class RecruitServiceImpl implements RecruitService{

	@Autowired
	RecruitDAO recruitDAO;
	
	@Override
	public boolean insertRecruit(RecruitmentVO recruitmentVO) throws Exception {
		System.out.println(recruitmentVO);
		boolean result = recruitDAO.insertRecruit(recruitmentVO);
		System.out.println(result);
		if(result)
			return true;
		else
			return false;
	}

	@Override
	public List<RecruitmentVO> getMyRecruitList(int owner) throws Exception {
		return recruitDAO.getMyRecruitList(owner);
	}

	@Override
	public List<RecruitThumbVO> getAreaRecruitList(int area) throws Exception {
		// TODO Auto-generated method stub
		return recruitDAO.getAreaRecruitList(area);
	}

	

	@Override
	public List<SimpleApplicantVO> getApplicantList(int rcodnum) throws Exception {
		// TODO Auto-generated method stub
		return recruitDAO.getApplicantList(rcodnum);
	}

	@Override
	public RecruitmentVO getRecruit(int rcodnum) throws Exception {
		// TODO Auto-generated method stub
		return recruitDAO.getRecruit(rcodnum);
	}

	@Override
	public List<RecruitThumbVO> getRecruitList(int start) {
		// TODO Auto-generated method stub
		return recruitDAO.getRecruitList(start);
	}

}
