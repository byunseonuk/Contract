package com.exam.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.CareerVO;
import com.exam.test.model.CertificateVO;
import com.exam.test.model.LanguageVO;
import com.exam.test.model.RecruitThumbVO;
import com.exam.test.model.RecruitmentVO;
import com.exam.test.model.ResumeVO;

@Repository
public class RecruitDAOImpl implements RecruitDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean insertRecruit(RecruitmentVO recruitmentVO) throws Exception {
		
		try {
			sqlSession.insert("recruitMapper.insertRecruit", recruitmentVO);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<RecruitmentVO> getMyRecruitList(int owner) throws Exception {
		return sqlSession.selectList("recruitMapper.getMyNotEndRecruitList", owner);
	}

	@Override
	public List<RecruitThumbVO> getAreaRecruitList(int area) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("recruitMapper.getAreaRecruitList", area);
	}

	@Override
	public RecruitmentVO getRecruit(int rcodnum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("recruitMapper.getRecruit", rcodnum);
	}

	@Override
	public List<SimpleApplicantVO> getApplicantList(int rcodnum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("recruitMapper.getApplicantList",rcodnum);
	}

	@Override
	public List<RecruitThumbVO> getRecruitList(int start) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("recruitMapper.getRecruitList",start);
	}


}
