package com.exam.test.dao;

import java.util.List;

import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.CareerVO;
import com.exam.test.model.CertificateVO;
import com.exam.test.model.LanguageVO;
import com.exam.test.model.RecruitThumbVO;
import com.exam.test.model.RecruitmentVO;
import com.exam.test.model.ResumeVO;

public interface RecruitDAO {
	public boolean insertRecruit(RecruitmentVO recruitmentVO) throws Exception;
	public List<RecruitmentVO> getMyRecruitList(int owner) throws Exception;
	public List<RecruitThumbVO> getAreaRecruitList(int area) throws Exception;
	public RecruitmentVO getRecruit(int rcodnum) throws Exception;
	public List<SimpleApplicantVO> getApplicantList(int rcodnum) throws Exception;
	public List<RecruitThumbVO> getRecruitList(int start);
	
}
