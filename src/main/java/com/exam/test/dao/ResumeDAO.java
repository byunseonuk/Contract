package com.exam.test.dao;

import java.sql.SQLException;
import java.util.List;

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


public interface ResumeDAO {
	public int insertResume(ResumeVO resume) throws Exception;
	public void insertCareer(CareerVO careerList, int resume_id) throws SQLException;
	public void insertCertificate(CertificateVO certificateList, int resume_id) throws SQLException;
	public void insertLanguage(LanguageVO languageList, int resume_id) throws SQLException;
	public ResumeVO getResume(int resume_no);
	public List<CareerVO> getCareer(int resume_no);
	public List<CertificateVO> getCertificate(int resume_no);
	public List<LanguageVO> getLanguage(int resume_no);
	public UserVO getApplicantInfo(int user_id);
	public List<ResumeVO> getMyResumeList(int get_id);
	public boolean submitApplicant(ApplicantVO applicant);
	public List<SimpleApplyVO> myApplyList(int _id);
	public void modifyResume(ResumeVO resume);
	public void modifyCareer(CareerVO career, int resume_id);
	public void modifyCertificate(CertificateVO certificate, int resume_id);
	public void modifyLanguage(LanguageVO language, int resume_id);
	

}
