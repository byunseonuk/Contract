package com.exam.test.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.test.dao.ResumeDAO;
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

@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	ResumeDAO resumeDAO;
	
	@Transactional
	@Override
	public int insertResume(ResumeVO resume, CareerVO career, CertificateVO certificate, LanguageVO language) throws Exception, SQLException {
		// TODO Auto-generated method stub
		try {
			int resume_id = resumeDAO.insertResume(resume);
			career.setResume_id(resume_id);
			resumeDAO.insertCareer(career,resume_id);
			
			certificate.setResume_id(resume_id);
			resumeDAO.insertCertificate(certificate,resume_id);
			
			language.setResume_id(resume_id);
			resumeDAO.insertLanguage(language,resume_id);
		}catch(SQLException e) {
			e.printStackTrace();
			return -2;
		}
		
		return -1;
	}

	@Override
	public void insertCareer(CareerVO careerList, int resume_id) {
		try {
			resumeDAO.insertCareer(careerList,resume_id);
		}catch(Exception e) {
			
		}
	}

	@Override
	public void insertCertificate(CertificateVO certificateList, int resume_id) {
		try {
			resumeDAO.insertCertificate(certificateList,resume_id);
		}catch(Exception e) {
			
		}	
	}

	@Override
	public void insertLanguage(LanguageVO languageList, int resume_id) {
		try {
			resumeDAO.insertLanguage(languageList,resume_id);
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public ResumeVO getResume(int resume_no) {
		return resumeDAO.getResume(resume_no);
	}

	@Override
	public List<CareerVO> getCareer(int resume_no) {
		return resumeDAO.getCareer(resume_no);
	}

	@Override
	public List<CertificateVO> getCertificate(int resume_no) {
		return resumeDAO.getCertificate(resume_no);
	}

	@Override
	public List<LanguageVO> getLanguage(int resume_no) {
		return resumeDAO.getLanguage(resume_no);
	}

	@Override
	public UserVO getApplicantInfo(int user_id) {
		// TODO Auto-generated method stub
		return resumeDAO.getApplicantInfo(user_id);
	}

	@Override
	public List<ResumeVO> getMyResumeList(int get_id) {
		// TODO Auto-generated method stub
		return resumeDAO.getMyResumeList(get_id);
	}

	@Override
	public boolean submitApplicant(ApplicantVO applicant) {
		// TODO Auto-generated method stub
		return resumeDAO.submitApplicant(applicant);
	}

	@Override
	public List<SimpleApplyVO> myApplyList(int _id) {
		// TODO Auto-generated method stub
		return resumeDAO.myApplyList(_id);
	}

	@Override
	public void modifyResume(ResumeVO resume) {
		// TODO Auto-generated method stub
		resumeDAO.modifyResume(resume);
	}

	@Override
	public void modifyCareer(CareerVO career, int resume_id) {
		resumeDAO.modifyCareer(career, resume_id);
		
	}

	@Override
	public void modifyCertificate(CertificateVO certificate, int resume_id) {
		resumeDAO.modifyCertificate(certificate, resume_id);
		
	}

	@Override
	public void modifyLanguage(LanguageVO language, int resume_id) {
		resumeDAO.modifyLanguage(language, resume_id);
		
	}


}
