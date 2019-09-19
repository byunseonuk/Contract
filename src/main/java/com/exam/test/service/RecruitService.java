package com.exam.test.service;

import java.util.List;

import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.RecruitThumbVO;
import com.exam.test.model.RecruitmentVO;

public interface RecruitService {
	public boolean insertRecruit(RecruitmentVO recruitmentVO) throws Exception;
	public List<RecruitmentVO> getMyRecruitList(int owner) throws Exception;
	public List<RecruitThumbVO> getAreaRecruitList(int area) throws Exception;
	public RecruitmentVO getRecruit(int rcodnum) throws Exception;
	public List<SimpleApplicantVO> getApplicantList(int rcodnum) throws Exception;
	public List<RecruitThumbVO> getRecruitList(int start);
	
}
