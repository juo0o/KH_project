package kh.study.intranet.alarm.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.alarm.vo.AlarmVO;
import kh.study.intranet.emp.vo.EmpVO;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertAlarm(AlarmVO alarmVO) {
		
	
		System.out.println(alarmVO.getAppSeq());
		System.out.println(alarmVO.getAppSeq());
		System.out.println(alarmVO.getAppSeq());
		sqlSession.insert("alarmMapper.insertAlarm",alarmVO);
	
	}

	@Override
	public List<AlarmVO> selectAlarm(AlarmVO alarmVO) {
		return sqlSession.selectList("alarmMapper.selectAlarm",alarmVO);
	}

	@Override
	public void updateAlarm(AlarmVO alarmVO) {
		sqlSession.update("alarmMapper.updateAlarm",alarmVO);
		
	}
	
	

	@Override
	public void updateEmpAlarm(EmpVO empVO) {
		sqlSession.insert("alarmMapper.updateEmpAlarm",empVO);
	}

	@Override
	public EmpVO selectEmpAlarm(EmpVO empVO) {
		return sqlSession.selectOne("alarmMapper.selectEmpAlarm",empVO);
	}
	
	
}
