package kh.study.intranet.alarm.service;

import java.util.List;

import kh.study.intranet.alarm.vo.AlarmVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface AlarmService {

	void insertAlarm(AlarmVO alarmVO);
	
	List<AlarmVO> selectAlarm(AlarmVO alarmVO);
	
	void updateAlarm(AlarmVO alarmVO);
	
	void updateEmpAlarm(EmpVO empVO);
	
	EmpVO selectEmpAlarm(EmpVO empVO);
}
