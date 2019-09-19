package com.exam.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.test.model.ApplicantVO;
import com.exam.test.model.CareerVO;
import com.exam.test.model.CertificateVO;
import com.exam.test.model.ChangeApplyStateVO;
import com.exam.test.model.ContractVO;
import com.exam.test.model.LanguageVO;
import com.exam.test.model.ResumeVO;
import com.exam.test.model.SimpleApplicantVO;
import com.exam.test.model.SimpleApplyVO;
import com.exam.test.model.UserVO;

@Repository
public class ResumeDAOImpl implements ResumeDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertResume(ResumeVO resume) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("resumeMapper.insertResume",resume);
		System.out.println("InsertedResume : "+resume);
		return resume.get_id();
	}

	@Override
	public void insertCareer(CareerVO career, int resume_id) throws SQLException {
		System.out.println(career);
		sqlSession.insert("resumeMapper.insertCareer",career);
		
	}

	@Override
	public void insertCertificate(CertificateVO certificate, int resume_id)  throws SQLException {
		/*for(CertificateVO c:certificate.getCertificateList()) {
			c.setResume_id(resume_id);
			sqlSession.insert("resumeMapper.insertCertificate",c);
		}*/
		
		sqlSession.insert("resumeMapper.insertCertificate",certificate);
	}

	@Override
	public void insertLanguage(LanguageVO language, int resume_id)  throws SQLException {
		/*for(LanguageVO l:language.getLanguageList()) {
			l.setResume_id(resume_id);
			sqlSession.insert("resumeMapper.insertLanguage",l);
		}*/
		sqlSession.insert("resumeMapper.insertLanguage",language);
	}

	@Override
	public ResumeVO getResume(int resume_no) {
		return sqlSession.selectOne("resumeMapper.getResume", resume_no);
	}

	@Override
	public List<CareerVO> getCareer(int resume_no) {
		return sqlSession.selectList("resumeMapper.getCareer", resume_no);
	} 

	@Override
	public List<CertificateVO> getCertificate(int resume_no) {
		return sqlSession.selectList("resumeMapper.getCertificate", resume_no);
	}

	@Override
	public List<LanguageVO> getLanguage(int resume_no) {
		return sqlSession.selectList("resumeMapper.getLanguage", resume_no);
	}

	@Override
	public UserVO getApplicantInfo(int user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("userMapper.getApplicantInfo",user_id);
	}

	@Override
	public List<ResumeVO> getMyResumeList(int get_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("resumeMapper.getMyResumeList",get_id);
	}

	@Override
	public boolean submitApplicant(ApplicantVO applicant) {
		// TODO Auto-generated method stub
		try {
			sqlSession.insert("resumeMapper.insertApply",applicant);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
		
	}

	@Override
	public List<SimpleApplyVO> myApplyList(int _id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("resumeMapper.myApplyList",_id);
	}

	@Override
	public void modifyResume(ResumeVO resume) {
		System.out.println("Enter Resume Modify");
		sqlSession.update("resumeMapper.modifyResume",resume);
		
	}

	@Override
	public void modifyCareer(CareerVO career, int resume_id) {
		System.out.println("Enter Resume Career");
		for(CareerVO c:career.getCareerList()) {
			c.setResume_id(resume_id);
			if(c.get_id()==0) {
				sqlSession.update("resumeMapper.insertCareer",c);
			}else {
				sqlSession.update("resumeMapper.modifyCareer",c);
			}
		}
		
	}

	@Override
	public void modifyCertificate(CertificateVO certificate, int resume_id) {
		System.out.println("Enter Resume Certificate");
		for(CertificateVO c:certificate.getCertificateList()) {
			c.setResume_id(resume_id);
			if(c.get_id()==0) {
				sqlSession.update("resumeMapper.insertCertificate",c);
			}else {
				sqlSession.update("resumeMapper.modifyCertificate",c);
			}
			
		}
	}

	@Override
	public void modifyLanguage(LanguageVO language, int resume_id) {
		System.out.println("Enter Resume Language");
		for(LanguageVO l:language.getLanguageList()) {
			l.setResume_id(resume_id);
			if(l.get_id()==0) {
				sqlSession.update("resumeMapper.insertLanguage",l);
			}else {
				sqlSession.update("resumeMapper.modifyLanguage",l);
			}
		}
	}



}
